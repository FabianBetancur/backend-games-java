package org.webservice.api.persistencedb2.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.coredb2.AssetStatesDto;
import org.webservice.api.persistencedb2.entity.AssetStates;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AssetStatesMapper {
    AssetStatesDto toAssetsStateDto(AssetStates state);
    List<AssetStatesDto> toAssetsStateDto(List<AssetStates> states);

    @InheritInverseConfiguration
    AssetStates toAssetsState(AssetStatesDto stateDto);
}
