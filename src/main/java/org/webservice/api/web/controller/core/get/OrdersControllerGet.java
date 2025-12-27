package org.webservice.api.web.controller.core.get;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.services.core.OrdersService;

@Tag(name = "10 - Controlador ordenes")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class OrdersControllerGet {
    private final Log LOGGER = LogFactory.getLog(OrdersControllerGet.class);
    private final OrdersService service;

    @Operation(summary = "Obtiene todas las ordenes", description = "Obtiene todos los resigtros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "lista obtenida correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @GetMapping("/order")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }

    @Operation(summary = "Obtiene todas las ordenes por id de usuario", description = "Obtiene todos los registros buscados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "lista obtenida correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @GetMapping("/order/user")
    public ResponseEntity<?> findByUserId(@RequestParam Long id){
        return new ResponseEntity<>(service.findByUserId(id), HttpStatus.OK);
    }
}
