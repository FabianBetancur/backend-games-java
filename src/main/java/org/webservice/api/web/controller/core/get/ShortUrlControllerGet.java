package org.webservice.api.web.controller.core.get;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.services.core.ShortUrlService;

import java.net.URI;
import java.util.Optional;

@Tag(name = "11 - Controlador acortador de url")
@RestController
@RequestMapping("/")
public class ShortUrlControllerGet {
    @Autowired
    private ShortUrlService service;

    @Operation(summary = "Obtiene y retorna la url acortada", description = "retorna url original y la abre en el navegador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "url obtenida correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @GetMapping("/url/{code}")
    public ResponseEntity<?> redirect(@PathVariable String code){
        Optional<String> originalUrl = service.getOriginalUrl(code);
        return originalUrl
                .map(url->ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build())
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}
