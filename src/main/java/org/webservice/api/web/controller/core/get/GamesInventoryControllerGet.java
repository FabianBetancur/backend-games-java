package org.webservice.api.web.controller.core.get;

import io.swagger.v3.oas.annotations.Operation;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.services.core.GamesInventoryService;

@Tag(name = "06 - Controlador inventario")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class GamesInventoryControllerGet {
    private final Log LOGGER = LogFactory.getLog(GamesInventoryControllerGet.class);
    private final GamesInventoryService service;

    @Operation(summary = "Obtiene todos los elementos en el inventario", description = "Lista de elementos en el inventario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Lista obtenida correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @GetMapping("/inventory")
    public ResponseEntity<?> getGames(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

}
