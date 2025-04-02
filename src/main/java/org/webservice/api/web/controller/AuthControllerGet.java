package org.webservice.api.web.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.UsersDto;
import org.webservice.api.domain.services.UserDtoService;
import org.webservice.api.domain.services.UserService;
import org.webservice.api.domain.services.UsersRolesService;
import org.webservice.api.web.security.JwtUtil;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthControllerGet {
    private final Log LOGGER = LogFactory.getLog(AuthControllerGet.class);
    private final UserService userService;
    private final UserDtoService userDtoService;
    private final UsersRolesService usersRolesService;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthControllerGet(UserService userService, UserDtoService userDtoService, UsersRolesService usersRolesService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.userDtoService = userDtoService;
        this.usersRolesService = usersRolesService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(@RequestHeader("Authorization")String token){
        try {
            Optional<UsersDto> user = userDtoService.findByUserId(Long.parseLong(jwtUtil.extractId(token.substring(7))));
            return ResponseEntity.ok(user);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new HashMap<String,String>(){{
                        put("message", ex.getMessage());
                    }});
        }
    }
}
