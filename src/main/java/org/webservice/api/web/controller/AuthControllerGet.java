package org.webservice.api.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
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

@Tag(name = "01 - Controlador autenticacion")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthControllerGet {
    private final Log LOGGER = LogFactory.getLog(AuthControllerGet.class);
    private final UserService userService;
    private final UserDtoService userDtoService;
    private final UsersRolesService usersRolesService;
    private final JwtUtil jwtUtil;

    @Operation(summary = "Obtiene la informacion del usuario", description = "obtiene un usuario a traves del token JWT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Usuario obtenido correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UsersDto.class))),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @GetMapping("/profile")
    //@SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<?> getProfile(@RequestHeader("Authorization")String token){
        try {
            Optional<UsersDto> user = userDtoService.getByEmail((jwtUtil.extractData(token.substring(7))));
            return ResponseEntity.ok(user);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(new HashMap<String,String>(){{
                        put("message", ex.getMessage());
                    }});
        }
    }
}
