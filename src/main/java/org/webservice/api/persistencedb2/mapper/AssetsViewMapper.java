package org.webservice.api.persistencedb2.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.coredb2.AssetsViewDto;
import org.webservice.api.persistencedb2.entity.AssetsView;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AssetsViewMapper {
    AssetsViewDto toAssetsViewDto(AssetsView assetsView);
    List<AssetsViewDto> toAssetsViewDto(List<AssetsView> assetsViewList);

    @InheritInverseConfiguration
    AssetsView toAssetsView(AssetsViewDto assetsViewDto);
}
