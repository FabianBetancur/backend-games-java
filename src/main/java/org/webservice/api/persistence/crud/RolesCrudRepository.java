package org.webservice.api.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistence.entity.Roles;

import java.util.Optional;

public interface RolesCrudRepository extends CrudRepository<Roles,Long> {
    Optional<Roles> findByRoleId(Long id);
}
