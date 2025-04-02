package org.webservice.api.web.controller.core.post;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.core.GamesDto;
import org.webservice.api.domain.services.core.GameService;

import java.util.HashMap;

@RestController
@RequestMapping("/")
public class GamesControllerPost {
    private final Log LOGGER = LogFactory.getLog(GamesControllerPost.class);
    private final GameService service;

    @Autowired
    public GamesControllerPost(GameService service) {
        this.service = service;
    }

    @PostMapping("/game")
    public ResponseEntity<?> saveGame(@RequestBody GamesDto request){
        try {

            if(request.getGameTitle() == null || request.getGameDescription() == null
               || request.getGameGenre() == null || request.getGamePlatform() == null
               || request.getGameDeveloper() == null || request.getGameClassification() == null
               || request.getReleaseDate() ==  null){
                LOGGER.error("incomplete data entered");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new HashMap<String,String>(){{
                            put("message","incomplete data entered");
                        }});
            }

            service.save(request);

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new HashMap<String,String>(){{
                        put("message","successful product creation");
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
