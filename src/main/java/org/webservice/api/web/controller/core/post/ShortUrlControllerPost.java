package org.webservice.api.web.controller.core.post;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.dto.UrlRequest;
import org.webservice.api.domain.services.core.ShortUrlService;

import java.util.HashMap;

@Tag(name = "11 - Controlador acortador de url")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ShortUrlControllerPost {
    private final ShortUrlService service;

    @Operation(summary = "Herramienta para acortar enlaces", description = "introducir el enlace para acortar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "tarea terminada correctamente"),
            @ApiResponse(responseCode = "500",description = "error interno del servidor")
    })
    @PostMapping("/shorten")
    public ResponseEntity<?> shortenUrl(@RequestBody UrlRequest request){
        String code = service.shortenUrl(request.getUrl(), request.getUserId());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new HashMap<String,String>(){{
                    put("url","http://localhost:9001/service/api/url/" + code);
                }});
    }
}
