package org.webservice.api.domain.services.servicesdb2;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.coredb2.AreasDto;
import org.webservice.api.persistencedb2.AreasRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AreasService {
    private final Log LOGGER = LogFactory.getLog(AreasService.class);
    private final AreasRepository repository;

    public Optional<List<AreasDto>> findAll(){
        return repository.findAll();
    }
}
