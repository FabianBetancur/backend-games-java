package org.webservice.api.domain.services.core;

import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.core.OrdersDto;
import org.webservice.api.persistence.core.OrdersRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrdersService {
    private final Log LOGGER = LogFactory.getLog(OrdersService.class);
    @Autowired
    private OrdersRepository repository;

    public Optional<OrdersDto> save(OrdersDto dto){
        return repository.save(dto);
    }

    public Optional<List<OrdersDto>> findByUserId(Long id){
        return repository.findByUserId(id);
    }

    public Optional<List<OrdersDto>> findAll(){
        return repository.findAll();
    }
}
