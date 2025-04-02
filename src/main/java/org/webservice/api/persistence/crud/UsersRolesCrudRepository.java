package org.webservice.api.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistence.entity.UsersRoles;

import java.util.List;

public interface UsersRolesCrudRepository extends CrudRepository<UsersRoles,Long> {
    List<UsersRoles> findByUserId(long id);
}
