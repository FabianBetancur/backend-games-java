package org.webservice.api.persistencedb2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.coredb2.MaintenancesDto;
import org.webservice.api.domain.repositorydb2.MaintenancesRepositoryDto;
import org.webservice.api.persistencedb2.crud.MaintenancesCrudRepository;
import org.webservice.api.persistencedb2.mapper.MaintenancesMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MaintenancesRepository implements MaintenancesRepositoryDto {
    private final MaintenancesCrudRepository repository;
    private final MaintenancesMapper mapper;

    @Override
    public Optional<List<MaintenancesDto>> findByAssetId(Long id) {
        return repository.findByAssetId(id)
                .map(mapper::toMaintenancesDto);
    }

    @Override
    public Optional<MaintenancesDto> save(MaintenancesDto dto) {
        return Optional.of(repository.save(mapper.toMaintenances(dto)))
                .map(mapper::toMaintenancesDto);
    }
}
