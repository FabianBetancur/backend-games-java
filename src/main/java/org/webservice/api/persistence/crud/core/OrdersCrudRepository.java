package org.webservice.api.persistence.crud.core;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistence.entity.core.Orders;

import java.util.List;
import java.util.Optional;

public interface OrdersCrudRepository extends CrudRepository<Orders,Long> {
    Optional<List<Orders>> findByUserId(Long id);
}
