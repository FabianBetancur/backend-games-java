package org.webservice.api.web.controller.db2.get;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.coredb2.BrandsDto;
import org.webservice.api.domain.coredb2.UsersAssetDto;
import org.webservice.api.domain.services.servicesdb2.BrandsService;
import org.webservice.api.web.exceptions.MessageResponse;

@Tag(name = "13 - Controlador Assets")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class BrandsControllerGet {
    private final Log LOGGER = LogFactory.getLog(BrandsControllerGet.class);
    private final BrandsService service;

    @Operation(summary = "Obtiene todas las Marcas", description = "Lista completa de elementos disponibles")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista obtenida correctamente",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = BrandsDto.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "error interno del servidor",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = MessageResponse.class)))
    })
    @GetMapping("/brands")
    public ResponseEntity<?> getAllBrands(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
