package org.webservice.api.domain.services.core;

import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.core.PlatformsDto;
import org.webservice.api.persistence.core.PlatformRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PlatformService {
    private final Log LOGGER = LogFactory.getLog(PlatformService.class);
    @Autowired
    private PlatformRepository repository;

    public Optional<List<PlatformsDto>> findAll(){
        return repository.findAll();
    }

    public PlatformsDto save(PlatformsDto platformsDto){
        return repository.save(platformsDto).get();
    }
}
