package org.webservice.api.persistencedb2.crud;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistencedb2.entity.Assets;

public interface AssetsCrudRepository extends CrudRepository<Assets,Long> {
}
