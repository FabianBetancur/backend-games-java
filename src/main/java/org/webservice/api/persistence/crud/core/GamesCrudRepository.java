package org.webservice.api.persistence.crud.core;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistence.entity.core.Games;

public interface GamesCrudRepository extends CrudRepository<Games,Long> {
}
