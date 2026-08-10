package org.webservice.api.domain.services.servicesdb2;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.coredb2.AssetsDto;
import org.webservice.api.domain.coredb2.AssetsTypesDto;
import org.webservice.api.persistencedb2.AssetsTypesRepository;
import org.webservice.api.web.exceptions.MessageResponse;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AssetsTypesService {
    private final Log LOGGER = LogFactory.getLog(AssetsTypesService.class);
    private final AssetsTypesRepository repository;

    public Optional<List<AssetsTypesDto>> findAll(){
        return repository.findAll();
    }

    public AssetsTypesDto save(AssetsTypesDto assetsTypesDto){
        return repository.save(assetsTypesDto)
                .orElseThrow(()->new IllegalStateException(
                        String.valueOf(new MessageResponse("unexpected error!"))));
    }
}
