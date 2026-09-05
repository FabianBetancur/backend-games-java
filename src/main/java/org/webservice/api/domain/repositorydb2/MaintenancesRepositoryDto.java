package org.webservice.api.domain.repositorydb2;

import org.webservice.api.domain.coredb2.MaintenancesDto;

import java.util.List;
import java.util.Optional;

public interface MaintenancesRepositoryDto {
    Optional<List<MaintenancesDto>> findByAssetId(Long id);
    Optional<MaintenancesDto> save(MaintenancesDto dto);
}
