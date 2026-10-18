package org.webservice.api.persistencedb2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.coredb2.AssetsViewDto;
import org.webservice.api.domain.repositorydb2.AssetsViewRepositoryDto;
import org.webservice.api.persistencedb2.crud.AssetsViewCrudRepository;
import org.webservice.api.persistencedb2.entity.AssetsView;
import org.webservice.api.persistencedb2.mapper.AssetsViewMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AssetsViewRepository implements AssetsViewRepositoryDto {
    private final AssetsViewCrudRepository repository;
    private final AssetsViewMapper mapper;

    @Override
    public Optional<List<AssetsViewDto>> findAll() {
        return Optional.of((List<AssetsView>) repository.findAll())
                .map(mapper::toAssetsViewDto);
    }

    @Override
    public Optional<List<AssetsViewDto>> searchAsset(String value) {
        return repository.searchAssets(value).map(mapper::toAssetsViewDto);
    }

    @Override
    public Optional<AssetsViewDto> findById(Long id) {
        return repository.findById(id).map(mapper::toAssetsViewDto);
    }
}
