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
import org.webservice.api.domain.coredb2.AreasDto;
import org.webservice.api.domain.services.servicesdb2.AreasService;
import org.webservice.api.web.exceptions.MessageResponse;

@Tag(name = "13 - Controlador Assets")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class AreasControllerPost {
    private final Log LOGGER = LogFactory.getLog(AreasControllerPost.class);
    private final AreasService service;

    @Operation(summary = "Guarda un area en la base de datos", description = "guarda un elemento en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Elemento guardado correctamente",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = AreasDto.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "error interno del servidor",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)))
    })
    @PostMapping("/area")
    public ResponseEntity<?> saveArea(@Valid @RequestBody AreasDto areasDto){
        return new ResponseEntity<>(service.save(areasDto), HttpStatus.OK);
    }
}
