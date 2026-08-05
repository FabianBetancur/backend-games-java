package org.webservice.api.persistencedb2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.coredb2.AssetsTypesDto;
import org.webservice.api.domain.repositorydb2.AssetsTypesRepositoryDto;
import org.webservice.api.persistencedb2.crud.AssetsTypesCrudRepository;
import org.webservice.api.persistencedb2.entity.AssetsTypes;
import org.webservice.api.persistencedb2.mapper.AssetsTypesMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AssetsTypesRepository implements AssetsTypesRepositoryDto {
    private final AssetsTypesCrudRepository repository;
    private final AssetsTypesMapper mapper;

    @Override
    public Optional<List<AssetsTypesDto>> findAll() {
        return Optional.of((List<AssetsTypes>) repository.findAll())
                .map(mapper::toAssetsTypesDto);
    }
}
