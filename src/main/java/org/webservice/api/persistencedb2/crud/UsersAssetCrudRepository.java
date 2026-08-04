package org.webservice.api.persistencedb2.crud;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistencedb2.entity.UsersAsset;

public interface UsersAssetCrudRepository extends CrudRepository<UsersAsset,Long> {
}
