package org.webservice.api.web.controller.core.get;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.services.core.GenreService;

@RestController
@RequestMapping("/")
public class GenresControllerGet {
    private final Log LOGGER = LogFactory.getLog(GenresControllerGet.class);
    private final GenreService service;

    @Autowired
    public GenresControllerGet(GenreService service) {
        this.service = service;
    }

    @GetMapping("/genres")
    public ResponseEntity<?> getGenres(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
}
