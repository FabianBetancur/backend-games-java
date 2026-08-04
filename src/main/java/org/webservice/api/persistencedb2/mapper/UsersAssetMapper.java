package org.webservice.api.persistencedb2.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.coredb2.UsersAssetDto;
import org.webservice.api.persistencedb2.entity.UsersAsset;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersAssetMapper {
    UsersAssetDto toUsersAssetDto(UsersAsset usersAsset);
    List<UsersAssetDto> toUsersAssetDto(List<UsersAsset> usersAssets);

    @InheritInverseConfiguration
    UsersAsset toUsersAsset(UsersAssetDto usersAssetDto);
}
