package org.webservice.api.domain.repositorydb2;

import org.webservice.api.domain.coredb2.AssetsDto;
import org.webservice.api.domain.coredb2.UsersAssetDto;

import java.util.List;
import java.util.Optional;

public interface UsersAssetRepositoryDto {
    Optional<List<UsersAssetDto>> findAll();
    Optional<UsersAssetDto> findById(Long id);
    Optional<UsersAssetDto> save(UsersAssetDto usersAssetDto);
}
