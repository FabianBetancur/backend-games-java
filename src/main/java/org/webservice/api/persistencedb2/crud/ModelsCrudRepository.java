package org.webservice.api.persistencedb2.crud;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistencedb2.entity.Models;

public interface ModelsCrudRepository extends CrudRepository<Models,Long> {
}
