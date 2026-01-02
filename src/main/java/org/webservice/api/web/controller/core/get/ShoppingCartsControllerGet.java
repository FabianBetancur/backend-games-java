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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.core.CartItemsDto;
import org.webservice.api.domain.core.ShoppingCartsDto;
import org.webservice.api.domain.services.core.ShoppingCartService;
import org.webservice.api.web.exceptions.MessageResponse;

import java.util.HashMap;
import java.util.Optional;

@Tag(name = "07 - Controlador carrito de compras")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ShoppingCartsControllerGet {
    private final Log LOGGER = LogFactory.getLog(ShoppingCartsControllerGet.class);
    private final ShoppingCartService service;

    @Operation(summary = "Obtiene una lista con todos los carritos de compra", description = "Obtiene una lista de elementos")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "lista obtenida correctamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ShoppingCartsDto.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "error interno del servidor",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MessageResponse.class)))
    })
    @GetMapping("/cart")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }

    @Operation(summary = "Obtiene carrito de compra por medio de su id", description = "Obtiene elementos por medio de un id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "elemento obtenido correctamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ShoppingCartsDto.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "error interno del servidor",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MessageResponse.class)))
    })
    @GetMapping("/cart/{id}")
    public ResponseEntity<?> getCartById(@PathVariable("id")Long id){
        try {
            Optional<ShoppingCartsDto> cart = service.findById(id);
            if(cart.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new HashMap<String,String>(){{
                            put("message","data not found");
                        }});
            }
            LOGGER.info("data obtained success");
            return ResponseEntity.ok(cart);
        } catch (Exception ex){
            LOGGER.error( "message" + ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST )
                    .body(new HashMap<String,String>(){{
                        put("message", ex.getMessage());
                    }});
        }
    }
}
