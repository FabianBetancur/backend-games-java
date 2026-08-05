package org.webservice.api.persistencedb2.crud;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistencedb2.entity.Brands;

public interface BrandsCrudRepository extends CrudRepository<Brands,Long> {
}
