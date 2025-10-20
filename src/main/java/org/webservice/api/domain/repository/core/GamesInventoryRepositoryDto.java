package org.webservice.api.domain.repository.core;

import org.webservice.api.domain.core.GamesInventoryDto;

import java.util.List;
import java.util.Optional;

public interface GamesInventoryRepositoryDto {
    Optional<List<GamesInventoryDto>> findAll();
    Optional<GamesInventoryDto> findById(Integer id);
    Optional<GamesInventoryDto> save(GamesInventoryDto dto);
}
