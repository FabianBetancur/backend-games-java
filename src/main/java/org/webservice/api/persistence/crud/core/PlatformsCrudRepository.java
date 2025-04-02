package org.webservice.api.persistence.crud.core;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistence.entity.core.Platforms;

public interface PlatformsCrudRepository extends CrudRepository<Platforms,Long> {
}
