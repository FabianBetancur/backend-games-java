package org.webservice.api.persistencedb2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.coredb2.AssetStatesDto;
import org.webservice.api.domain.repositorydb2.AssetStatesRepositoryDto;
import org.webservice.api.persistencedb2.crud.AssetStatesCrudRepository;
import org.webservice.api.persistencedb2.entity.AssetStates;
import org.webservice.api.persistencedb2.mapper.AssetStatesMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AssetStatesRepository implements AssetStatesRepositoryDto {
    private final AssetStatesCrudRepository repository;
    private final AssetStatesMapper mapper;

    @Override
    public Optional<List<AssetStatesDto>> findAll() {
        return Optional.of((List<AssetStates>) repository.findAll())
                .map(mapper::toAssetsStateDto);
    }
}
