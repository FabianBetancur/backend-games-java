package org.webservice.api.domain.services.servicesdb2;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.coredb2.UsersAssetDto;
import org.webservice.api.persistencedb2.UsersAssetRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsersAssetService {
    private final Log LOGGER = LogFactory.getLog(UsersAssetService.class);
    private final UsersAssetRepository repository;

    public Optional<List<UsersAssetDto>> findAll(){
        return repository.findAll();
    }
}
