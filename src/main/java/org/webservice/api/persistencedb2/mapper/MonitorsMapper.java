package org.webservice.api.persistencedb2.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.coredb2.MonitorsDto;
import org.webservice.api.persistencedb2.entity.Monitors;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MonitorsMapper {
    MonitorsDto toMonitorsDto (Monitors monitors);
    List<MonitorsDto> toMonitorsDto (List<Monitors> monitorsList);

    @InheritInverseConfiguration
    Monitors toMonitors(MonitorsDto monitorsDto);
}
