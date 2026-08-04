package org.webservice.api.persistencedb2.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.coredb2.AssetsDto;
import org.webservice.api.persistencedb2.entity.Assets;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AssetsMapper {
    AssetsDto toAssetsDto(Assets asset);
    List<AssetsDto> toAssetsDto(List<Assets> assets);

    @InheritInverseConfiguration
    Assets toAssets(AssetsDto assetsDto);

}
