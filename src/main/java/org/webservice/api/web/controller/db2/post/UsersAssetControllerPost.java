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
import org.springframework.web.bind.annotation.*;
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
        service.save(request);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @Operation(summary = "Actualiza un usuario en la base de datos", description = "Actualiza un elemento en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Elemento Actualizado correctamente",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "error interno del servidor",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)))
    })
    @PutMapping("/user-asset/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,@RequestBody UsersAssetRequest request){
        try {
            if(service.update(id,request)){
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new MessageResponse("successful data update"));
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse("unexpected error"));
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new MessageResponse(ex.getMessage()));
        }
    }
}
