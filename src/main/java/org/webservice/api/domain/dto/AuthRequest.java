package org.webservice.api.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AuthRequest {
    @Schema(description = "correo del usuario", example = "user1@user.com")
    private String email;
    @Schema(description = "contraseña del usuario", example = "12345678")
    private String password;

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}