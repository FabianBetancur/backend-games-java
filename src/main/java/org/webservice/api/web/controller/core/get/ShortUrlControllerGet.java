package org.webservice.api.web.controller.core.get;

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

@RestController
@RequestMapping("/")
public class ShortUrlControllerGet {
    @Autowired
    private ShortUrlService service;

    @GetMapping("/url/{code}")
    public ResponseEntity<?> redirect(@PathVariable String code){
        Optional<String> originalUrl = service.getOriginalUrl(code);
        return originalUrl
                .map(url->ResponseEntity.status(HttpStatus.FOUND).location(URI.create(url)).build())
                .orElseGet(()->ResponseEntity.notFound().build());
    }
}
