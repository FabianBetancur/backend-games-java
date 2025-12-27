package org.webservice.api.domain.services.core;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.core.GamesInventoryDto;
import org.webservice.api.persistence.core.GamesInventoryRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class GamesInventoryService {
    private final Log LOGGER = LogFactory.getLog(GamesInventoryService.class);
    private final GamesInventoryRepository repository;

    public Optional<List<GamesInventoryDto>> findAll(){
        return repository.findAll();
    }

    public GamesInventoryDto save(GamesInventoryDto dto){
        LOGGER.info("Saving...");
        return repository.save(dto).orElseThrow(()->new IllegalStateException("unexpected error"));
    }
}
