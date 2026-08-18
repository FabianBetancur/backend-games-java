package org.webservice.api.persistencedb2.crud;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistencedb2.entity.Monitors;

public interface MonitorsCrudRepository extends CrudRepository<Monitors,Long> {
}
