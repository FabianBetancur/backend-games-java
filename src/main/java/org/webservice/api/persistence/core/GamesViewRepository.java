package org.webservice.api.persistence.core;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.core.GamesViewDto;
import org.webservice.api.domain.repository.core.GamesViewRepositoryDto;
import org.webservice.api.persistence.crud.core.GamesViewCrudRepository;
import org.webservice.api.persistence.entity.core.GamesView;
import org.webservice.api.persistence.mapper.core.GamesViewMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class GamesViewRepository implements GamesViewRepositoryDto {
    private final GamesViewCrudRepository repository;
    private final GamesViewMapper mapper;

    @Override
    public Optional<List<GamesViewDto>> findAll() {
        return Optional.of((List<GamesView>) repository.findAll())
                .map(mapper::toGamesViewDto);
    }

    @Override
    public Optional<List<GamesViewDto>> findWithoutInventory() {
        return repository.findWithoutInventory()
                .map(mapper::toGamesViewDto);
    }

    @Override
    public Optional<Page<GamesViewDto>> paginatedList(Pageable pageable) {
        return Optional.of(repository.findAll(pageable)
                .map(mapper::toGamesViewDto));
    }

    @Override
    public Optional<Page<GamesViewDto>> searchGames(String value, Pageable pageable) {
        return Optional.of(repository.searchGames(value, pageable)
                .map(mapper::toGamesViewDto));
    }
}
