package org.webservice.api.domain.services.servicesdb2;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.coredb2.ModelsDto;
import org.webservice.api.persistencedb2.ModelsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ModelsService {
    private final Log LOGGER = LogFactory.getLog(ModelsService.class);
    private final ModelsRepository repository;

    public Optional<List<ModelsDto>> findAll(){
        return repository.findAll();
    }
}
