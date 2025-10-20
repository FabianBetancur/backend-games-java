package org.webservice.api.persistence.crud.core;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistence.entity.core.ShoppingCarts;

import java.util.Optional;

public interface ShoppingCartsCrudRepository extends CrudRepository<ShoppingCarts,Long> {
}
