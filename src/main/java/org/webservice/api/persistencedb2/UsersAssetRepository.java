package org.webservice.api.persistencedb2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.coredb2.UsersAssetDto;
import org.webservice.api.domain.repositorydb2.UsersAssetRepositoryDto;
import org.webservice.api.persistencedb2.crud.UsersAssetCrudRepository;
import org.webservice.api.persistencedb2.entity.UsersAsset;
import org.webservice.api.persistencedb2.mapper.UsersAssetMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor

public class UsersAssetRepository implements UsersAssetRepositoryDto {
    private final UsersAssetCrudRepository repository;
    private final UsersAssetMapper mapper;

    @Override
    public Optional<List<UsersAssetDto>> findAll() {
        return Optional.of((List<UsersAsset>) repository.findAll())
                .map(mapper::toUsersAssetDto);
    }

    @Override
    public Optional<UsersAssetDto> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toUsersAssetDto);
    }

    @Override
    public Optional<UsersAssetDto> save(UsersAssetDto usersAssetDto) {
        return Optional.of(repository.save(mapper.toUsersAsset(usersAssetDto)))
                .map(mapper::toUsersAssetDto);
    }
}
