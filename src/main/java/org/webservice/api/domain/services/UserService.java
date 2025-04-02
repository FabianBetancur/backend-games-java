package org.webservice.api.domain.services;

import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.UsersDto;
import org.webservice.api.web.security.JwtUtil;

@Service
@Transactional
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final Log LOGGER = LogFactory.getLog(UserService.class);
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDtoService userDtoService;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserDtoService userDtoService) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDtoService = userDtoService;
    }

    public String loginUser(String userName,String password){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
        UsersDto user =  userDtoService.getByEmail(userName).get();
        return jwtUtil.generateToken(user.getUserId());
    }

    public UsersDto registerUser(UsersDto userDto){
        String encodedPassword = passwordEncoder.encode(userDto.getUserPassword());
        userDto.setUserPassword(encodedPassword);
        return userDtoService.save(userDto);
    }

    public boolean updatePassword(String token,String newPassword){
        LOGGER.info("changing password...");
        return userDtoService.findByUserId(Long.parseLong(jwtUtil.extractId(token)))
                .map(user->{
                    String encodedPassword = passwordEncoder.encode(newPassword);
                    user.setUserPassword(encodedPassword);
                    userDtoService.save(user);
                    LOGGER.info("successful update");
                    return true;
                }).orElse(false);
    }
}
