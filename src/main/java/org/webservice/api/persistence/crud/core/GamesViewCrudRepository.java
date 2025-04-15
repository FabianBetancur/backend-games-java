package org.webservice.api.persistence.crud.core;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistence.entity.core.GamesView;

public interface GamesViewCrudRepository extends CrudRepository<GamesView,Long> {
}
