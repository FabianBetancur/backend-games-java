package org.webservice.api.persistencedb2.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.coredb2.AssetsTypesDto;
import org.webservice.api.persistencedb2.entity.AssetsTypes;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AssetsTypesMapper {
    AssetsTypesDto toAssetsTypesDto(AssetsTypes assetsType);
    List<AssetsTypesDto> toAssetsTypesDto(List<AssetsTypes> assetsTypes);

    @InheritInverseConfiguration
    AssetsTypes toAssetsTypes(AssetsTypesDto assetsTypesDto);
}
