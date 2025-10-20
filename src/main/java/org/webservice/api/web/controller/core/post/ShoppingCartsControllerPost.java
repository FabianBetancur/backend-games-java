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
import org.webservice.api.domain.core.ShoppingCartsDto;
import org.webservice.api.domain.services.core.ShoppingCartService;

import java.time.LocalDateTime;
import java.util.HashMap;

@Tag(name = "07 - Controlador carrito de compras")
@RestController
@RequestMapping("/")
public class ShoppingCartsControllerPost {
    private final Log LOGGER = LogFactory.getLog(ShoppingCartsControllerPost.class);
    private final ShoppingCartService service;

    @Autowired
    public ShoppingCartsControllerPost(ShoppingCartService service) {
        this.service = service;
    }

    @Operation(summary = "registro de carrito de compra", description = "crea un registro nuevo en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Guardado correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @PostMapping("/cart")
    public ResponseEntity<?> saveCart(@RequestBody ShoppingCartsDto request){
        try {
            if(request.getUserId() == null){
                LOGGER.error("incomplete data entered");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new HashMap<String,String>(){{
                            put("message","incomplete data entered");
                        }});
            }
            service.save(request);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new HashMap<String,String>(){{
                        put("message","successful cart creation");
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
