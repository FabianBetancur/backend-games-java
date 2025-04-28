package org.webservice.api.persistence.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.core.GamesDto;
import org.webservice.api.domain.repository.core.GamesRepositoryDto;
import org.webservice.api.persistence.crud.core.GamesCrudRepository;
import org.webservice.api.persistence.entity.core.Games;
import org.webservice.api.persistence.mapper.core.GamesMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class GamesRepository implements GamesRepositoryDto {
    private final GamesCrudRepository repository;
    private final GamesMapper mapper;

    @Autowired
    public GamesRepository(GamesCrudRepository repository, GamesMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<GamesDto>> findAll() {
        List<Games> gamesList = (List<Games>) repository.findAll();
        return Optional.of(mapper.toGamesDto(gamesList));
    }

    @Override
    public Optional<GamesDto> findById(Long id) {
        return Optional.of(mapper.toGamesDto(repository.findById(id).get()));
    }

    public GamesDto save(GamesDto gamesDto){
        return mapper.toGamesDto(repository.save(mapper.toGames(gamesDto)));
    }
}
