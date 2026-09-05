package org.webservice.api.domain.services.servicesdb2;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.coredb2.MaintenancesDto;
import org.webservice.api.domain.dto.db2.MaintenanceRequest;
import org.webservice.api.persistencedb2.MaintenancesRepository;
import org.webservice.api.web.exceptions.MessageResponse;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MaintenancesService {
    private final Log LOGGER = LogFactory.getLog(MaintenancesService.class);
    private final MaintenancesRepository repository;

    public Optional<List<MaintenancesDto>> findByAssetId(Long id){
        return repository.findByAssetId(id);
    }

    public MaintenancesDto save(MaintenanceRequest request){
        MaintenancesDto dto = new MaintenancesDto();
        dto.setComment(request.getComment());
        dto.setAssetId(request.getAssetId());
        dto.setRegisterDate(null);
        return repository.save(dto)
                .orElseThrow(()->new IllegalStateException(
                   String.valueOf(new MessageResponse("unexpected error!"))
                ));
    }
}
