package org.webservice.api.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistence.entity.Users;

import java.util.Optional;

public interface UsersCrudRepository extends CrudRepository<Users,Long> {
    Optional<Users> findByUserEmail(String email);
    Optional<Users> findByUserId (Long id);
}
