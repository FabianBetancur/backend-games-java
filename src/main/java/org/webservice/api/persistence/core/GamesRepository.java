package org.webservice.api.persistence.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.core.GamesDto;
import org.webservice.api.domain.repository.core.GamesRepositoryDto;
import org.webservice.api.persistence.crud.core.GamesCrudRepository;
import org.webservice.api.persistence.entity.core.Games;
import org.webservice.api.persistence.mapper.core.GamesMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GamesRepository implements GamesRepositoryDto {
    private final GamesCrudRepository repository;
    private final GamesMapper mapper;

    @Override
    public Optional<List<GamesDto>> findAll() {
        return Optional.of((List<Games>) repository.findAll()).map(mapper::toGamesDto);
    }

    @Override
    public Optional<GamesDto> findById(Long id) {
        return repository.findById(id).map(mapper::toGamesDto);
    }

    @Override
    public Optional<GamesDto> save(GamesDto dto) {
        return Optional.of(repository.save(mapper.toGames(dto))).map(mapper::toGamesDto);
    }
}
