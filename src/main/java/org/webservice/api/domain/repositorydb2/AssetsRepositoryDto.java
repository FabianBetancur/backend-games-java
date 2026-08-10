package org.webservice.api.domain.repositorydb2;

import org.webservice.api.domain.coredb2.AssetsDto;

import java.util.List;
import java.util.Optional;

public interface AssetsRepositoryDto {
    Optional<List<AssetsDto>> findAll();
    Optional<AssetsDto> save(AssetsDto dto);
}
