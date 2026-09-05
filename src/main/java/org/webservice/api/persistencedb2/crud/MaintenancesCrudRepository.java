package org.webservice.api.persistencedb2.crud;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistencedb2.entity.Maintenances;

import java.util.List;
import java.util.Optional;

public interface MaintenancesCrudRepository extends CrudRepository<Maintenances,Long> {
    Optional<List<Maintenances>> findByAssetId(Long id);
}
