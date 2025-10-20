package org.webservice.api.web.controller.core.get;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.services.core.GenreService;

@Tag(name = "04 - Controlador generos")
@RestController
@RequestMapping("/")
public class GenresControllerGet {
    private final Log LOGGER = LogFactory.getLog(GenresControllerGet.class);
    private final GenreService service;

    @Autowired
    public GenresControllerGet(GenreService service) {
        this.service = service;
    }

    @Operation(summary = "Obtiene todos los generos", description = "Lista completa de generos de juegos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Lista obtenida correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @GetMapping("/genres")
    public ResponseEntity<?> getGenres(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
