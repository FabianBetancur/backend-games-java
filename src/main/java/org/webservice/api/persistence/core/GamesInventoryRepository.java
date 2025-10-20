package org.webservice.api.persistence.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.core.GamesInventoryDto;
import org.webservice.api.domain.repository.core.GamesInventoryRepositoryDto;
import org.webservice.api.persistence.crud.core.GamesInventoryCrudRepository;
import org.webservice.api.persistence.entity.core.GamesInventory;
import org.webservice.api.persistence.mapper.core.GameInventoryMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class GamesInventoryRepository implements GamesInventoryRepositoryDto {
    @Autowired
    private GamesInventoryCrudRepository repository;
    @Autowired
    private GameInventoryMapper mapper;

    @Override
    public Optional<List<GamesInventoryDto>> findAll() {
        return Optional.of((List<GamesInventory>) repository.findAll()).map(mapper::toGamesInventoryDto);
    }

    @Override
    public Optional<GamesInventoryDto> findById(Integer id) {
        return repository.findById(id).map(mapper::toGamesInventoryDto);
    }

    @Override
    public Optional<GamesInventoryDto> save(GamesInventoryDto dto) {
        return Optional.of(repository.save(mapper.toGamesInventory(dto))).map(mapper::toGamesInventoryDto);
    }

}
