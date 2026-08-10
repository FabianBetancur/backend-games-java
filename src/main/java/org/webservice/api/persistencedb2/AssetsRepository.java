package org.webservice.api.persistencedb2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.coredb2.AssetsDto;
import org.webservice.api.domain.repositorydb2.AssetsRepositoryDto;
import org.webservice.api.persistencedb2.crud.AssetsCrudRepository;
import org.webservice.api.persistencedb2.entity.Assets;
import org.webservice.api.persistencedb2.mapper.AssetsMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AssetsRepository implements AssetsRepositoryDto {
    private final AssetsCrudRepository repository;
    private final AssetsMapper mapper;

    @Override
    public Optional<List<AssetsDto>> findAll() {
        return Optional.of((List<Assets>) repository.findAll())
                .map(mapper::toAssetsDto);
    }

    @Override
    public Optional<AssetsDto> save(AssetsDto dto) {
        return Optional.of(repository.save(mapper.toAssets(dto)))
                .map(mapper::toAssetsDto);
    }
}
