package org.webservice.api.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.UsersDto;
import org.webservice.api.persistence.entity.Users;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    UsersDto toUsersDto(Users users);
    List<UsersDto> toUsersDto(List<Users> users);

    @InheritInverseConfiguration
    Users toUsers(UsersDto usersDto);
}
