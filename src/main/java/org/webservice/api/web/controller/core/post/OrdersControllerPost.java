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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.core.OrdersDto;
import org.webservice.api.domain.services.core.OrdersService;

import java.util.HashMap;

@Tag(name = "10 - Controlador ordenes")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class OrdersControllerPost {
    private final Log LOGGER = LogFactory.getLog(OrdersControllerPost.class);
    private final OrdersService service;

    @Operation(summary = "Resgitrar la orden", description = "crea un registro nuevo en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Guardado correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @PostMapping("/order")
    public ResponseEntity<?> saveOrder(@RequestBody OrdersDto request){
        try {
            if(request.getCartId() == null || request.getUserId() == null || request.getPaymentId() == null){
                LOGGER.error("incomplete data entered");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new HashMap<String,String>(){{
                            put("message","incomplete data entered");
                        }});
            }
            service.save(request);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(new HashMap<String,String>(){{
                        put("message","order generated successfully");
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
