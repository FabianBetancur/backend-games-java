package org.webservice.api.persistence;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.RolesDto;
import org.webservice.api.domain.repository.RolesRepositoryDto;
import org.webservice.api.persistence.crud.RolesCrudRepository;
import org.webservice.api.persistence.entity.Roles;
import org.webservice.api.persistence.mapper.RolesMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RolesRepository implements RolesRepositoryDto {
    private final RolesCrudRepository repository;
    private final RolesMapper mapper;

    @Override
    public Optional<List<RolesDto>> findAll() {
        List<Roles> rolesList = (List<Roles>) repository.findAll();
        return Optional.of(mapper.toRolesDto(rolesList));
    }

    @Override
    public Optional<RolesDto> findByRoleId(long id) {
        return repository.findByRoleId(id)
                .map(mapper::toRolesDto);
    }
}
