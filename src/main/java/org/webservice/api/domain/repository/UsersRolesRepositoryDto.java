package org.webservice.api.domain.repository;

import org.webservice.api.domain.UsersRolesDto;

import java.util.List;
import java.util.Optional;

public interface UsersRolesRepositoryDto {
    UsersRolesDto save(UsersRolesDto userRolesDTO);
    Optional<List<UsersRolesDto>> findAll();
    Optional<List<UsersRolesDto>> findByUserId(long id);
}
