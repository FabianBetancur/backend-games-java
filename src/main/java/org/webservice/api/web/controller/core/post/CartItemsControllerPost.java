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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.core.CartItemsDto;
import org.webservice.api.domain.services.core.CartItemsService;

import java.util.HashMap;

@Tag(name = "09 - Controlador items del carrito")
@RestController
@RequestMapping("/")
public class CartItemsControllerPost {
    private final Log LOGGER = LogFactory.getLog(CartItemsControllerPost.class);
    private final CartItemsService service;

    @Autowired
    public CartItemsControllerPost(CartItemsService service) {
        this.service = service;
    }

    @Operation(summary = "Resgitra items asociados a un carrito de compra", description = "crea un registro nuevo y lo asocia al carrito")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Guardado correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @PostMapping("/cart-items")
    public ResponseEntity<?> saveItem(@RequestBody CartItemsDto request){
        try {
            if(request.getCartId() == null || request.getGameId() == null
            || request.getQuantity() == null){
                LOGGER.error("incomplete data entered");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new HashMap<String,String>(){{
                            put("message","incomplete data entered");
                        }});
            }
            service.save(request);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new HashMap<String,String>(){{
                        put("message","successful item save");
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
