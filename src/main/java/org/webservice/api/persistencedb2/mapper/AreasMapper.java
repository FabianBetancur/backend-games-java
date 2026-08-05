package org.webservice.api.persistencedb2.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.coredb2.AreasDto;
import org.webservice.api.persistencedb2.entity.Areas;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AreasMapper {
    AreasDto toAreasDto(Areas area);
    List<AreasDto> toAreasDto(List<Areas> areas);

    @InheritInverseConfiguration
    Areas toAreas(AreasDto areasDto);
}
