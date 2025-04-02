package org.webservice.api.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.RolesDto;
import org.webservice.api.persistence.entity.Roles;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RolesMapper {
    RolesDto toRolesDto(Roles roles);
    List<RolesDto> toRolesDto(List<Roles> rolesList);

    @InheritInverseConfiguration
    Roles toRoles(RolesDto rolesDto);
}
