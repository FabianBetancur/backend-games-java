package org.webservice.api.domain.repository.core;

import org.webservice.api.domain.core.OrdersDto;

import java.util.List;
import java.util.Optional;

public interface OrdersRepositoryDto {
    Optional<List<OrdersDto>> findByUserId(Long id);
    Optional<List<OrdersDto>> findAll();
    Optional<OrdersDto> save(OrdersDto dto);
}
