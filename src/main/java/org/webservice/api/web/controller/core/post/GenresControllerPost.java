package org.webservice.api.web.controller.core.post;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webservice.api.domain.core.GenresDto;
import org.webservice.api.domain.services.core.GenreService;

import java.util.HashMap;

@RestController
@RequestMapping("/")
public class GenresControllerPost {
    private final Log LOGGER = LogFactory.getLog(GenresControllerPost.class);
    private final GenreService service;

    @Autowired
    public GenresControllerPost(GenreService service) {
        this.service = service;
    }

    @PostMapping("/genre")
    public ResponseEntity<?> saveGenre(@RequestBody GenresDto request){
        try {
            if (request.getGenreName().isEmpty() || request.getGenreDescription().isEmpty()){
                LOGGER.error("Incomplete data");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new HashMap<String,String>(){{
                            put("message","Incomplete data");
                        }});
            } else {

                service.save(request);
                LOGGER.info("successful genre creation");
                return ResponseEntity.status(HttpStatus.OK)
                        .body(new HashMap<String,String>(){{
                            put("message","successful genre creation");
                        }});
            }
        } catch (Exception ex){
            LOGGER.error(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new HashMap<String,String>(){{
                        put("message",ex.getMessage());
                    }});
        }
    }
}
