package org.webservice.api.domain.repositorydb2;

import org.webservice.api.domain.coredb2.AssetsTypesDto;

import java.util.List;
import java.util.Optional;

public interface AssetsTypesRepositoryDto {
    Optional<List<AssetsTypesDto>> findAll();
    Optional<AssetsTypesDto> save(AssetsTypesDto dto);
}
