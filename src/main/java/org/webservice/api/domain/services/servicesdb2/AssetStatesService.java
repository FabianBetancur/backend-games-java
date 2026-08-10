package org.webservice.api.domain.services.servicesdb2;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.coredb2.AssetStatesDto;
import org.webservice.api.persistencedb2.AssetStatesRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AssetStatesService {
    private final Log LOGGER = LogFactory.getLog(AssetStatesService.class);
    private final AssetStatesRepository repository;

    public Optional<List<AssetStatesDto>> findAll(){
        return repository.findAll();
    }

    public Optional<AssetStatesDto> save(AssetStatesDto assetStatesDto){
        return repository.save(assetStatesDto);
    }
}
