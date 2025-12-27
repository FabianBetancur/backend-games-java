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
import org.springframework.web.bind.annotation.*;
import org.webservice.api.domain.core.CartItemsDto;
import org.webservice.api.domain.services.core.CartItemsService;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Tag(name = "09 - Controlador items del carrito")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class CartItemsControllerGet {
    private final Log LOGGER = LogFactory.getLog(CartItemsControllerGet.class);
    private final CartItemsService service;

    @Operation(summary = "Obtiene los items del carrito a traves del id", description = "Obtiene el elemento a traves del id del carrito")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "elemento obtenido correctamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CartItemsDto.class))),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @GetMapping("/cart-items/{id}")
    public ResponseEntity<?> getByUserId(@PathVariable("id") long id){
        try {
            return service.findByCartId(id)
                    .map(cart -> {
                        LOGGER.info("data obtained success");
                        return new ResponseEntity<>(cart,HttpStatus.OK);
                    })
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception ex){
            LOGGER.error( "message" + ex.getMessage());
            return ResponseEntity.ok(new HashMap<String,String>(){{
                put("message", ex.getMessage());
            }});
        }
    }
}
