package org.webservice.api.domain.services.servicesdb2;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.coredb2.AssetsDto;
import org.webservice.api.domain.coredb2.AssetsViewDto;
import org.webservice.api.persistencedb2.AssetsRepository;
import org.webservice.api.persistencedb2.AssetsViewRepository;
import org.webservice.api.web.exceptions.MessageResponse;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AssetsService {
    private final Log LOGGER = LogFactory.getLog(AssetsService.class);
    private final AssetsRepository repository;
    private final AssetsViewRepository viewRepository;

    public Optional<List<AssetsDto>> findAll(){
        return repository.findAll();
    }

    public Optional<List<AssetsViewDto>> findAllView(){
        return viewRepository.findAll();
    }

    public AssetsDto save(AssetsDto assetsDto){
        return repository.save(assetsDto)
                .orElseThrow(()->new IllegalStateException(
                        String.valueOf(new MessageResponse("unexpected error!"))));
    }
}
