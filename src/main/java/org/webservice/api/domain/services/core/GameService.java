package org.webservice.api.domain.services.core;

import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.core.GamesDto;
import org.webservice.api.domain.core.GamesViewDto;
import org.webservice.api.persistence.core.GamesRepository;
import org.webservice.api.persistence.core.GamesViewRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GameService {
    private final Log LOGGER = LogFactory.getLog(GameService.class);
    private final GamesRepository repository;
    private final GamesViewRepository repositoryView;

    @Autowired
    public GameService(GamesRepository repository, GamesViewRepository repositoryView) {
        this.repository = repository;
        this.repositoryView = repositoryView;
    }

    public Optional<List<GamesDto>> findAll(){
        return repository.findAll();
    }

    public Optional<List<GamesViewDto>> findAllView(){
        return repositoryView.findAll();
    }

    public Optional<GamesDto> findById(Long id){
        return repository.findById(id);
    }

    public GamesDto save(GamesDto gamesDto){
        return repository.save(gamesDto);
    }

    public Boolean update(Long id,GamesDto gamesDto){
        try {
            repository.findById(id).map(data->{
               data.setGameTitle(gamesDto.getGameTitle());
               data.setGameDescription(gamesDto.getGameDescription());
               data.setGameGenre(gamesDto.getGameGenre());
               data.setGamePlatform(gamesDto.getGamePlatform());
               data.setGameDeveloper(gamesDto.getGameDeveloper());
               data.setGameClassification(gamesDto.getGameClassification());
               data.setReleaseDate(gamesDto.getReleaseDate());
               return repository.save(data);
            });
            return true;
        } catch (Exception ex){
            LOGGER.error(ex.getMessage());
            return false;
        }
    }
}
