package org.webservice.api.domain.repository.core;

import org.webservice.api.domain.core.ShoppingCartsDto;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartsRepositoryDto {
    Optional<ShoppingCartsDto> findById(Long id);
    Optional<List<ShoppingCartsDto>> findAll();
    Optional<ShoppingCartsDto> save(ShoppingCartsDto dto);
}
