package org.webservice.api.persistence.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.core.OrdersDto;
import org.webservice.api.domain.repository.core.OrdersRepositoryDto;
import org.webservice.api.persistence.crud.core.OrdersCrudRepository;
import org.webservice.api.persistence.entity.core.Orders;
import org.webservice.api.persistence.mapper.core.OrdersMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class OrdersRepository implements OrdersRepositoryDto {
    @Autowired
    private OrdersCrudRepository repository;
    @Autowired
    private OrdersMapper mapper;

    @Override
    public Optional<OrdersDto> save(OrdersDto dto){
        return Optional.of(repository.save(mapper.toEntity(dto))).map(mapper::toDto);
    }

    @Override
    public Optional<List<OrdersDto>> findByUserId(Long id) {
        return repository.findByUserId(id).map(mapper::toDto);
    }

    @Override
    public Optional<List<OrdersDto>> findAll() {
        return Optional.of((List<Orders>) repository.findAll()).map(mapper::toDto);
    }
}


