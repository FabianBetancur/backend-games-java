package org.webservice.api.domain.repository.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.webservice.api.domain.core.GamesViewDto;

import java.util.List;
import java.util.Optional;

public interface GamesViewRepositoryDto {
    Optional<List<GamesViewDto>> findAll();
    Optional<List<GamesViewDto>> findWithoutInventory();
    Optional<Page<GamesViewDto>> paginatedList(Pageable pageable);
    Optional<Page<GamesViewDto>> searchGames(String value,Pageable pageable);
}
