package org.webservice.api.domain.repository.core;

import org.webservice.api.domain.core.PlatformsDto;

import java.util.List;
import java.util.Optional;

public interface PlatformsRepositoryDto {
    Optional<List<PlatformsDto>> findAll();
}
