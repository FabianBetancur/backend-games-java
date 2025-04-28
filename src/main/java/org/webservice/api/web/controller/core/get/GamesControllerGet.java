package org.webservice.api.web.controller.core.get;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.core.GamesDto;
import org.webservice.api.domain.services.core.GameService;

import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class GamesControllerGet {
    private final Log LOGGER = LogFactory.getLog(GamesControllerGet.class);
    private final GameService service;

    @Autowired
    public GamesControllerGet(GameService service) {
        this.service = service;
    }

    @GetMapping("/games")
    public ResponseEntity<?> getGames(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/games/view")
    public ResponseEntity<?> getGamesView(){
        return new ResponseEntity<>(service.findAllView(),HttpStatus.OK);
    }

    @GetMapping("/game/{id}")
    public ResponseEntity<?> getGameById(@PathVariable("id")Long id){
        try {
            Optional<GamesDto> game = service.findById(id);
            if(game.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new HashMap<String,String>(){{
                            put("message","data not found");
                        }});
            }
            LOGGER.info("data obtained success");
            return ResponseEntity.ok(game);
        } catch (Exception ex){
            LOGGER.error( "message" + ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST )
                    .body(new HashMap<String,String>(){{
                        put("message", ex.getMessage());
                    }});
        }
    }
}
