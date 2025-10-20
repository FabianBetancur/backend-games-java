package org.webservice.api.web.controller.core.post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webservice.api.domain.core.PlatformsDto;
import org.webservice.api.domain.services.core.PlatformService;

import java.util.HashMap;

@Tag(name = "05 - Controlador plataformas")
@RestController
@RequestMapping("/")
public class PlatformControllerPost {
    private final Log LOGGER = LogFactory.getLog(PlatformControllerPost.class);
    private final PlatformService service;

    @Autowired
    public PlatformControllerPost(PlatformService service) {
        this.service = service;
    }

    @Operation(summary = "Guarda el registro de plataforma del juego", description = "Lista completa de elementos disponibles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Lista obtenida correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @PostMapping("/platform")
    public ResponseEntity<?> savePlatform(@RequestBody PlatformsDto request) {
        try {
            if(!request.getPlatformName().isEmpty() && !request.getPlatformDescription().isEmpty()){
                service.save(request);
                LOGGER.info("successful platform creation");
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new HashMap<String,String>(){{
                            put("message","successful platform creation");
                        }});
            } else {
                LOGGER.error("Incomplete data");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new HashMap<String,String>(){{
                            put("message","Incomplete data");
                        }});
            }
        } catch (Exception ex){
            LOGGER.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new HashMap<String,String>(){{
                        put("message",ex.getMessage());
                    }});
        }
    }
}
