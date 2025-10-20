package org.webservice.api.persistence.crud.core;


import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistence.entity.core.Games;

import java.util.Optional;

public interface GamesCrudRepository extends CrudRepository<Games,Long> {
    Optional<Games> findById(Long id);
}
