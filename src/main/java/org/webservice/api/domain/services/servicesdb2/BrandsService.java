package org.webservice.api.domain.services.servicesdb2;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.coredb2.BrandsDto;
import org.webservice.api.persistencedb2.BrandsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BrandsService {
    private final Log LOGGER = LogFactory.getLog(BrandsService.class);
    private final BrandsRepository repository;

    public Optional<List<BrandsDto>> findAll(){
        return repository.findAll();
    }
}
