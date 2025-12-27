package org.webservice.api.web.controller.core.post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.core.GamesInventoryDto;
import org.webservice.api.domain.services.core.GamesInventoryService;

import java.util.HashMap;

@Tag(name = "06 - Controlador inventario")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class GamesInventoryControllerPost {
    private final Log LOGGER = LogFactory.getLog(GamesInventoryControllerPost.class);
    private final GamesInventoryService service;

    @Operation(summary = "Guarda el elemento en el inventario", description = "Guarda el elemento en base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Guardado correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @PostMapping("/inventory")
    public ResponseEntity<?> saveGame(@RequestBody GamesInventoryDto request){
        try {
            if (request.getGameId() == null || request.getDownloadUrl() == null){
                LOGGER.error("incomplete data entered");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new HashMap<String,String>(){{
                            put("message","incomplete data entered");
                        }});
            }
            service.save(request);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new HashMap<String,String>(){{
                        put("message","successful data save");
                    }});
        } catch (Exception ex){
            LOGGER.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new HashMap<String,String>(){{
                        put("message",ex.getMessage());
                    }});
        }
    }
}
