package org.webservice.api.persistencedb2.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.coredb2.ModelsDto;
import org.webservice.api.persistencedb2.entity.Models;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModelsMapper {
    ModelsDto toModelsDto(Models model);
    List<ModelsDto> toModelsDto(List<Models> models);

    @InheritInverseConfiguration
    Models toModels(ModelsDto modelsDto);
}
