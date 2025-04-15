package org.webservice.api.domain.repository.core;

import org.webservice.api.domain.core.GamesViewDto;

import java.util.List;
import java.util.Optional;

public interface GamesViewRepositoryDto {
    Optional<List<GamesViewDto>> findAll();
}
