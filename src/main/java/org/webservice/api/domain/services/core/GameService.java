package org.webservice.api.domain.services.core;

import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.core.GamesDto;
import org.webservice.api.persistence.core.GamesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GameService {
    private final Log LOGGER = LogFactory.getLog(GameService.class);
    private final GamesRepository repository;

    @Autowired
    public GameService(GamesRepository repository) {
        this.repository = repository;
    }

    public Optional<List<GamesDto>> findAll(){
        return repository.findAll();
    }

    public GamesDto save(GamesDto gamesDto){
        return repository.save(gamesDto);
    }
}
