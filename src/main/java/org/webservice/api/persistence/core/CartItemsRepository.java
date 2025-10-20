package org.webservice.api.persistence.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.core.CartItemsDto;
import org.webservice.api.domain.repository.core.CartItemsRepositoryDto;
import org.webservice.api.persistence.crud.core.CartItemsCrudRepository;
import org.webservice.api.persistence.mapper.core.CartItemsMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class CartItemsRepository implements CartItemsRepositoryDto {
    @Autowired
    private CartItemsCrudRepository repository;
    @Autowired
    private CartItemsMapper mapper;

    @Override
    public Optional<List<CartItemsDto>> findByCartId(Long id) {
        return repository.findByCartId(id).map(mapper::toDto);
    }

    @Override
    public Optional<CartItemsDto> save(CartItemsDto dto) {
        return Optional.of((repository.save(mapper.toEntity(dto)))).map(mapper::toDto);
    }
}
