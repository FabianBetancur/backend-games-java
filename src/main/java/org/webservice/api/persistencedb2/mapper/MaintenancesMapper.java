package org.webservice.api.persistencedb2.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.coredb2.MaintenancesDto;
import org.webservice.api.persistencedb2.entity.Maintenances;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MaintenancesMapper {
    MaintenancesDto toMaintenancesDto(Maintenances maintenances);
    List<MaintenancesDto> toMaintenancesDto(List<Maintenances> maintenancesList);

    @InheritInverseConfiguration
    Maintenances toMaintenances(MaintenancesDto maintenancesDto);
}
