package org.webservice.api.persistence.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.core.GamesViewDto;
import org.webservice.api.domain.repository.core.GamesViewRepositoryDto;
import org.webservice.api.persistence.crud.core.GamesViewCrudRepository;
import org.webservice.api.persistence.entity.core.GamesView;
import org.webservice.api.persistence.mapper.core.GamesViewMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class GamesViewRepository implements GamesViewRepositoryDto {
    private final GamesViewCrudRepository repository;
    private final GamesViewMapper mapper;

    @Autowired
    public GamesViewRepository(GamesViewCrudRepository repository, GamesViewMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<GamesViewDto>> findAll() {
        List<GamesView> gamesViewList = (List<GamesView>) repository.findAll();
        return Optional.of(mapper.toGamesViewDto(gamesViewList));
    }
}
