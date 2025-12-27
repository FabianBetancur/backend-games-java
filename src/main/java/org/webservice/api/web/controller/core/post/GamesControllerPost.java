package org.webservice.api.web.controller.core.post;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webservice.api.domain.core.GamesDto;
import org.webservice.api.domain.services.core.GameService;
import org.webservice.api.web.exceptions.MessageResponse;

import java.util.HashMap;

@Tag(name = "03 - Controlador juegos")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class GamesControllerPost {
    private final Log LOGGER = LogFactory.getLog(GamesControllerPost.class);
    private final GameService service;

    @Operation(summary = "Guarda el elemento en la base de datos", description = "guerda el elemento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Guardado correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @PostMapping("/game")
    public ResponseEntity<?> saveGame(@Valid @RequestBody GamesDto request){
        service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new MessageResponse("successful game creation"));
    }

    @Operation(summary = "Actualiza el elemento en la base de datos", description = "Actualiza la informacion del elemento")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Actualizado correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @PutMapping("/game/{id}")
    public ResponseEntity<?> updateGame(@PathVariable Long id,@RequestBody GamesDto request){
        try {
            if(service.update(id,request)){
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new HashMap<String,String>(){{
                            put("message","successful data update");
                        }});
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new HashMap<String,String>(){{
                        put("message","unexpected error");
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
