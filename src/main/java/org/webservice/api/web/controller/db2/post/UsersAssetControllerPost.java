package org.webservice.api.web.controller.db2.post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.coredb2.UsersAssetDto;
import org.webservice.api.domain.dto.db2.AssetsRequest;
import org.webservice.api.domain.dto.db2.UsersAssetRequest;
import org.webservice.api.domain.services.servicesdb2.UsersAssetService;
import org.webservice.api.web.exceptions.MessageResponse;

@Tag(name = "13 - Controlador Assets")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UsersAssetControllerPost {
    private final Log LOGGER = LogFactory.getLog(UsersAssetControllerPost.class);
    private final UsersAssetService service;

    @Operation(summary = "Guarda un usuario en la base de datos", description = "guarda un elemento en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Elemento guardado correctamente",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = UsersAssetRequest.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "error interno del servidor",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)))
    })
    @PostMapping("/user-asset")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UsersAssetRequest request){
        UsersAssetDto dto = new UsersAssetDto();
        dto.setName(request.getName());
        dto.setEmployeeId(request.getEmployeeId());
        dto.setAreaId(request.getAreaId());
        service.save(dto);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }
}
