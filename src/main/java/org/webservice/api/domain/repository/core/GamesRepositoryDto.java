package org.webservice.api.domain.repository.core;

import org.webservice.api.domain.core.GamesDto;

import java.util.List;
import java.util.Optional;

public interface GamesRepositoryDto {
    Optional<List<GamesDto>> findAll();
    Optional<GamesDto> findById(Long id);
}
