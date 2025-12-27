package org.webservice.api.web.controller.core.get;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.services.core.PaymentTransactionService;

@Tag(name = "09 - Controlador transacciones")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class PaymentTransactionsControllerGet {
    private final Log LOGGER = LogFactory.getLog(PaymentTransactionsControllerGet.class);
    private final PaymentTransactionService service;

    @Operation(summary = "Obtiene todas las transacciones", description = "Obtiene todos los resigtros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "lista obtenida correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @GetMapping("/transaction")
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

}
