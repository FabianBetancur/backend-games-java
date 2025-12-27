package org.webservice.api.web.controller.core.post;

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
import org.springframework.web.bind.annotation.*;
import org.webservice.api.domain.core.GenresDto;
import org.webservice.api.domain.services.core.GenreService;

import java.util.HashMap;

@Tag(name = "04 - Controlador generos")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class GenresControllerPost {
    private final Log LOGGER = LogFactory.getLog(GenresControllerPost.class);
    private final GenreService service;

    @Operation(summary = "Guarda el registro de genero del juego", description = "guarda el genero en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "guardado correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @PostMapping("/genre")
    public ResponseEntity<?> saveGenre(@RequestBody GenresDto request){
        try {
            if (request.getGenreName().isEmpty() || request.getGenreDescription().isEmpty()){
                LOGGER.error("Incomplete data");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new HashMap<String,String>(){{
                            put("message","Incomplete data");
                        }});
            } else {

                service.save(request);
                LOGGER.info("successful genre creation");
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new HashMap<String,String>(){{
                            put("message","successful genre creation");
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
