package org.webservice.api.domain.repository;

import org.webservice.api.domain.RolesDto;

import java.util.List;
import java.util.Optional;

public interface RolesRepositoryDto {
    Optional<List<RolesDto>> findAll();
    Optional<RolesDto> findByRoleId(long id);
}