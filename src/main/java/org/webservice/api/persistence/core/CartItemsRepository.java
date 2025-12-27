package org.webservice.api.persistence.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.core.CartItemsDto;
import org.webservice.api.domain.repository.core.CartItemsRepositoryDto;
import org.webservice.api.persistence.crud.core.CartItemsCrudRepository;
import org.webservice.api.persistence.mapper.core.CartItemsMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CartItemsRepository implements CartItemsRepositoryDto {
    private final CartItemsCrudRepository repository;
    private final CartItemsMapper mapper;

    @Override
    public Optional<List<CartItemsDto>> findByCartId(Long id) {
        return repository.findByCartId(id).map(mapper::toDto);
    }

    @Override
    public Optional<CartItemsDto> save(CartItemsDto dto) {
        return Optional.of((repository.save(mapper.toEntity(dto)))).map(mapper::toDto);
    }
}
