package org.webservice.api.persistencedb2.crud;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistencedb2.entity.AssetStates;

public interface AssetStatesCrudRepository extends CrudRepository<AssetStates,Long> {
}
