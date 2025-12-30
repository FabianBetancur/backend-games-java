package org.webservice.api.domain.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.UsersDto;
import org.webservice.api.web.security.JwtUtil;

import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final Log LOGGER = LogFactory.getLog(UserService.class);
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDtoService userDtoService;

    public String loginUser(String userName,String password){
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userName,password));
        return jwtUtil.generateToken(userDtoService.getByEmail(userName)
                .orElseThrow(NoSuchElementException::new)
                .getUserId());
    }

    public UsersDto registerUser(UsersDto userDto){
        String encodedPassword = passwordEncoder.encode(userDto.getUserPassword());
        userDto.setUserPassword(encodedPassword);
        return userDtoService.save(userDto);
    }

    public boolean updatePassword(String token,String newPassword){
        LOGGER.info("changing password...");
        return userDtoService.getByEmail((jwtUtil.extractData(token)))
                .map(user->{
                    String encodedPassword = passwordEncoder.encode(newPassword);
                    user.setUserPassword(encodedPassword);
                    userDtoService.save(user);
                    LOGGER.info("successful update");
                    return true;
                }).orElse(false);
    }
}
