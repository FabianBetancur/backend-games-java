package org.webservice.api.web.controller.core.get;

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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webservice.api.domain.core.GamesDto;
import org.webservice.api.domain.core.GamesViewDto;
import org.webservice.api.domain.services.core.GameService;

import java.util.HashMap;

@Tag(name = "03 - Controlador juegos")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class GamesControllerGet {
    private final Log LOGGER = LogFactory.getLog(GamesControllerGet.class);
    private final GameService service;

    @Operation(summary = "Obtiene todos los elementos a vender", description = "Lista completa de elementos disponibles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Lista obtenida correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @GetMapping("/games")
    public ResponseEntity<?> getGames(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @Operation(summary = "Obtiene todos los elementos para la vista", description = "Lista completa de elementos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Lista obtenida correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @GetMapping("/games/view")
    public ResponseEntity<?> getGamesView(){
        return new ResponseEntity<>(service.findAllView(),HttpStatus.OK);
    }

    @Operation(summary = "Obtiene lista de elementos fuera del inventario", description = "lista de elementos sin un inventario asociado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Lista obtenida correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @GetMapping("/games/without")
    public ResponseEntity<?> getGamesWithoutInventory(){return new ResponseEntity<>(service.findWithoutInventory(),HttpStatus.OK);}

    @Operation(summary = "Obtiene un elemento por su id", description = "juego seleccionado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "objeto obtenido correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GamesDto.class))),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @GetMapping("/game/{id}")
    public ResponseEntity<?> getGameById(@PathVariable("id")Long id){
        try {
           return service.findById(id)
                   .map(game->{
                       LOGGER.info("data obtained success");
                       return new ResponseEntity<>(game,HttpStatus.OK);
                   })
                   .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception ex){
            LOGGER.error( "message" + ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST )
                    .body(new HashMap<String,String>(){{
                        put("message", ex.getMessage());
                    }});
        }
    }

    @Operation(summary = "Obtiene una lista de elementos paginados", description = "elementos paginados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "lista obtenida correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GamesViewDto.class))),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @GetMapping("/game/paginated")
    public ResponseEntity<?> paginatedList(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "3") int size){
        return new ResponseEntity<>(service.paginatedList(page, size),HttpStatus.OK);
    }

    @Operation(summary = "Obtiene una lista de elementos por busqueda", description = "elementos buscados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "lista obtenida correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GamesViewDto.class))),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @GetMapping("/game/search")
    public ResponseEntity<?> searchGames(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size,
                                         @RequestParam String value
                                         ){
        return new ResponseEntity<>(service.searchGames(page, size, value),HttpStatus.OK);
    }
}
