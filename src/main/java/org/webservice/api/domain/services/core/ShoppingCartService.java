package org.webservice.api.domain.services.core;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.core.ShoppingCartsDto;
import org.webservice.api.persistence.core.ShoppingCartsRepository;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
public class ShoppingCartService {
    private final Log LOGGER = LogFactory.getLog(ShoppingCartService.class);
    private final ShoppingCartsRepository repository;

    public Optional<ShoppingCartsDto> findById(Long id){
        return repository.findById(id);
    }

    public Optional<List<ShoppingCartsDto>> findAll(){return repository.findAll();}

    public ShoppingCartsDto save(ShoppingCartsDto dto){
        return repository.save(dto).get();
    }
}
