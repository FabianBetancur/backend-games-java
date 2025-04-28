package org.webservice.api.web.controller.core.post;


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

@RestController
@RequestMapping("/")
public class ShortUrlControllerPost {
    @Autowired
    private ShortUrlService service;

    @PostMapping("/shorten")
    public ResponseEntity<?> shortenUrl(@RequestBody UrlRequest request){
        String code = service.shortenUrl(request.getUrl(), request.getUserId());
        return ResponseEntity.status(HttpStatus.OK)
                .body(new HashMap<String,String>(){{
                    put("url","http://localhost:9001/service/api/url/" + code);
                }});
    }
}
