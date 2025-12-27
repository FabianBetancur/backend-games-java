package org.webservice.api.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.UsersRolesDto;
import org.webservice.api.domain.repository.UsersRolesRepositoryDto;
import org.webservice.api.persistence.crud.UsersCrudRepository;
import org.webservice.api.persistence.crud.UsersRolesCrudRepository;
import org.webservice.api.persistence.entity.UsersRoles;
import org.webservice.api.persistence.mapper.UsersRolesMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UsersRolesRepository implements UsersRolesRepositoryDto {
    private final UsersRolesCrudRepository repository;
    private final UsersRolesMapper mapper;

    @Override
    public UsersRolesDto save(UsersRolesDto userRolesDTO) {
        return mapper.toUsersRolesDto(repository.save(mapper.toUsersRoles(userRolesDTO)));
    }

    @Override
    public Optional<List<UsersRolesDto>> findAll() {
        List<UsersRoles> usersRolesList = (List<UsersRoles>) repository.findAll();
        return Optional.of(mapper.toUsersRolesDto(usersRolesList));
    }

    @Override
    public Optional<List<UsersRolesDto>> findByUserId(long id) {
        return Optional.of(mapper.toUsersRolesDto(repository.findByUserId(id)));
    }
}
