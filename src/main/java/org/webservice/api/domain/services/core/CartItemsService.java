package org.webservice.api.domain.services.core;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.core.CartItemsDto;
import org.webservice.api.persistence.core.CartItemsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CartItemsService {
    private final Log LOGGER = LogFactory.getLog(CartItemsService.class);
    private final CartItemsRepository repository;

    public Optional<List<CartItemsDto>> findByCartId(Long id){
        return repository.findByCartId(id);
    }

    public Optional<CartItemsDto> save(CartItemsDto dto){
        return repository.save(dto);
    }
}
