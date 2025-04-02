package org.webservice.api.persistence.mapper.core;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.core.PlatformsDto;
import org.webservice.api.persistence.entity.core.Platforms;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlatformsMapper {
    PlatformsDto toPlatformsDto(Platforms platforms);
    List<PlatformsDto> toPlatformsDto(List<Platforms> platforms);

    @InheritInverseConfiguration
    Platforms toPlatforms(PlatformsDto platformsDto);
}
