package org.webservice.api.domain.services.servicesdb2;

import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webservice.api.domain.coredb2.MonitorsDto;
import org.webservice.api.domain.dto.db2.MonitorsRequest;
import org.webservice.api.persistencedb2.MonitorsRepository;
import org.webservice.api.web.exceptions.MessageResponse;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MonitorsService {
    private final Log LOGGER = LogFactory.getLog(MonitorsService.class);
    private final MonitorsRepository repository;

    public Optional<List<MonitorsDto>> findAll(){
        return repository.findAll();
    }

    public MonitorsDto save(MonitorsRequest request){
        MonitorsDto dto = new MonitorsDto();
        dto.setSerialNumber(request.getSerialNumber());
        dto.setBrandId(request.getBrandId());
        return repository.save(dto)
                .orElseThrow(()->new IllegalStateException(
                        String.valueOf(new MessageResponse("unexpected error!"))
                ));
    }
}
