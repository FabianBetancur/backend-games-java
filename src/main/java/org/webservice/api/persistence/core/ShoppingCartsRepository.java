package org.webservice.api.persistence.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.core.ShoppingCartsDto;
import org.webservice.api.domain.repository.core.ShoppingCartsRepositoryDto;
import org.webservice.api.persistence.crud.core.ShoppingCartsCrudRepository;
import org.webservice.api.persistence.entity.core.ShoppingCarts;
import org.webservice.api.persistence.mapper.core.ShoppingCartsMapper;

import java.util.List;
import java.util.Optional;
@Repository
public class ShoppingCartsRepository implements ShoppingCartsRepositoryDto {
    @Autowired
    private ShoppingCartsCrudRepository repository;
    @Autowired
    private ShoppingCartsMapper mapper;

    @Override
    public Optional<ShoppingCartsDto> findById(Long id) {
        return repository.findById(id).map(obj-> mapper.toDto(obj));
    }

    @Override
    public Optional<List<ShoppingCartsDto>> findAll() {
        return Optional.of((List<ShoppingCarts>) repository.findAll()).map(mapper::toDto);
    }

    @Override
    public Optional<ShoppingCartsDto> save(ShoppingCartsDto dto) {
        return Optional.of(repository.save(mapper.toEntity(dto))).map(mapper::toDto);
    }
}
