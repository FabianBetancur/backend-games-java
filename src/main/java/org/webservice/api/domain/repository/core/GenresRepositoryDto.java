package org.webservice.api.domain.repository.core;

import org.webservice.api.domain.core.GenresDto;

import java.util.List;
import java.util.Optional;

public interface GenresRepositoryDto {
    Optional<List<GenresDto>> findAll();
    Optional<GenresDto> save(GenresDto dto);
}
