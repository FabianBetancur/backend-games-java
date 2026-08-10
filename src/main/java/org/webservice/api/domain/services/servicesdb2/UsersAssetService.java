package org.webservice.api.domain.services.servicesdb2;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.coredb2.UsersAssetDto;
import org.webservice.api.domain.dto.db2.UsersAssetRequest;
import org.webservice.api.persistencedb2.UsersAssetRepository;
import org.webservice.api.web.exceptions.MessageResponse;

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

    public UsersAssetDto save(UsersAssetRequest request){
        UsersAssetDto dto = new UsersAssetDto();
        dto.setName(request.getName());
        dto.setEmployeeId(request.getEmployeeId());
        dto.setAreaId(request.getAreaId());
        return repository.save(dto)
                .orElseThrow(()->new IllegalStateException(
                        String.valueOf(new MessageResponse("unexpected error!"))
                ));
    }

    public Boolean update(Long id, UsersAssetRequest request){
        try {
            repository.findById(id).map(user->{
                user.setName(request.getName());
                user.setEmployeeId(request.getEmployeeId());
                user.setAreaId(request.getAreaId());
                return repository.save(user);
            });
            return true;
        } catch (Exception ex){
            LOGGER.debug(ex.getMessage());
            return false;
        }
    }
}
