package org.webservice.api.web.controller.core.get;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webservice.api.domain.services.core.GameService;

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
}
