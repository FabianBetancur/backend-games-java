package org.webservice.api.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.webservice.api.domain.UsersRolesDto;
import org.webservice.api.persistence.entity.UsersRoles;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UsersRolesMapper {
    UsersRolesDto toUsersRolesDto(UsersRoles usersRoles);
    List<UsersRolesDto> toUsersRolesDto(List<UsersRoles> usersRoles);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "user",ignore = true),
            @Mapping(target = "role",ignore = true)
    })
    UsersRoles toUsersRoles (UsersRolesDto rolesDto);
}
