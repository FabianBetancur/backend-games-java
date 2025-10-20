package org.webservice.api.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.webservice.api.domain.UsersRolesDto;
import org.webservice.api.persistence.entity.UsersRoles;

import java.util.List;


@Mapper(componentModel = "spring", uses = {UsersMapper.class, RolesMapper.class})
public interface UsersRolesMapper {
    UsersRolesDto toUsersRolesDto(UsersRoles usersRoles);
    List<UsersRolesDto> toUsersRolesDto(List<UsersRoles> usersRoles);

    @InheritInverseConfiguration
    UsersRoles toUsersRoles (UsersRolesDto rolesDto);
}
