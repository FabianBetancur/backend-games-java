package org.webservice.api.domain.repository.core;

import org.webservice.api.domain.core.CartItemsDto;

import java.util.List;
import java.util.Optional;

public interface CartItemsRepositoryDto {
    Optional<List<CartItemsDto>> findByCartId(Long id);
    Optional<CartItemsDto> save(CartItemsDto dto);
}
