package org.webservice.api.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;
import org.webservice.api.domain.UsersDto;
import org.webservice.api.domain.UsersRolesDto;
import org.webservice.api.domain.dto.AuthRequest;
import org.webservice.api.domain.dto.RefreshTokenRequest;
import org.webservice.api.domain.dto.UserRegistrationRequest;
import org.webservice.api.domain.services.UserDtoService;
import org.webservice.api.domain.services.UserService;
import org.webservice.api.domain.services.UsersRolesService;
import org.webservice.api.web.security.JwtUtil;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthControllerPost {
    private final Log LOGGER = LogFactory.getLog(AuthControllerPost.class);
    private final UserService userService;
    private final UserDtoService userDtoService;
    private final UsersRolesService usersRolesService;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthControllerPost(UserService userService, UserDtoService userDtoService, UsersRolesService usersRolesService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.userDtoService = userDtoService;
        this.usersRolesService = usersRolesService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> RegisterUser(@RequestBody UserRegistrationRequest request){
        try {
            if(request.getEmail().isEmpty() || request.getPassword().isEmpty()){
                LOGGER.error("incomplete data entered");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new HashMap<String,String>(){{
                            put("message","incomplete data entered");
                        }});
            }
            if (request.getPassword().length() < 8){
                LOGGER.error("password is to short");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new HashMap<String,String>(){{
                            put("message","password is to short");
                        }});
            }
            if(!userDtoService.getByEmail(request.getEmail()).isEmpty()){
                LOGGER.error("this account already exists");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new HashMap<String,String>(){{
                            put("message", "this account already exists");
                        }});
            }

            UsersDto user = new UsersDto();
            user.setUserName(request.getUsername());
            user.setUserEmail(request.getEmail());
            user.setUserPassword(request.getPassword());
            user.setUserLocked(false);
            user.setUserDisabled(false);
            user.setUserCreated(LocalDateTime.now());

            UsersDto userDto = userService.registerUser(user);
            UsersRolesDto dto = new UsersRolesDto();
            dto.setUserId(userDto.getUserId());
            dto.setRoleId((long)2);
            dto.setGrantedDate(LocalDateTime.now());
            usersRolesService.save(dto);
            LOGGER.info("successful user creation");

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new HashMap<String,String>(){{
                        put("message","successful user creation");
                    }});

        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new HashMap<String,String>(){{
                        put("message",ex.getMessage());
                    }});
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> LoginUser (@RequestBody AuthRequest request){
        try {
            String token = userService.loginUser(request.getEmail(), request.getPassword());
            UsersDto user =  userDtoService.getByEmail(request.getEmail()).get();
            String refreshToken = jwtUtil.generateRefreshToken(user.getUserId());
            LOGGER.info("logged user: " + user.getUserEmail());
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new HashMap<String,String>(){{
                        put("refreshToken",refreshToken);
                        put("accessToken",token);
                    }});
        } catch (AuthenticationException ex){
            LOGGER.error("login error: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new HashMap<String,String>(){{
                        put("message",ex.getMessage());
                    }});
        }
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<?> getRefreshToken(@RequestBody RefreshTokenRequest request){
        try {
                long id = Long.parseLong(jwtUtil.extractId(request.getToken()));
                String token = jwtUtil.generateToken(id);
                String refreshToken = jwtUtil.generateRefreshToken(id);
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new HashMap<String,String>(){{
                            put("accessToken",token);
                            put("refreshToken",refreshToken);
                        }});
        } catch (Exception ex){
            LOGGER.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
        }
    }

    @PostMapping("/available/{email}")
    public ResponseEntity<?> isAvailable(@PathVariable("email") String email){
        Optional<UsersDto> user  = userDtoService.getByEmail(email);
        if(user.isEmpty()){
            LOGGER.error("this email does not exist: " + email);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new HashMap<String,Boolean>(){{
                        put("isAvailable",true);
                    }});
        }
        LOGGER.info("the email is valid: " + email);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new HashMap<String,Boolean>(){{
                    put("isAvailable",false);
                }});
    }
}