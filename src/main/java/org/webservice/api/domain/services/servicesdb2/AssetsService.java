package org.webservice.api.domain.services.servicesdb2;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.coredb2.AssetsDto;
import org.webservice.api.domain.coredb2.AssetsViewDto;
import org.webservice.api.domain.dto.db2.AssetsRequest;
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

    public Optional<AssetsDto> findById(Long id){
        return repository.findById(id);
    }

    public Optional<List<AssetsViewDto>> findAllView(){
        return viewRepository.findAll();
    }

    public Optional<AssetsViewDto> findViewById(Long id){
        return viewRepository.findById(id);
    }

    public Optional<List<AssetsViewDto>> searchAssets(String value){
        return viewRepository.searchAsset(value);
    }

    public Boolean update(Long id, AssetsRequest assetsRequest){
        try {
            repository.findById(id).map(asset->{
                asset.setBrandId(assetsRequest.getBrandId());
                asset.setModelId(assetsRequest.getModelId());
                asset.setTypeId(assetsRequest.getTypeId());
                asset.setSerialNumber(assetsRequest.getSerialNumber());
                asset.setHostName(assetsRequest.getHostName());
                asset.setUniqueId(assetsRequest.getUniqueId());
                asset.setAssignedUserId(assetsRequest.getAssignedUserId());
                asset.setStateId(assetsRequest.getStateId());
                asset.setMonitorId(assetsRequest.getMonitorId());
                return repository.save(asset);
            });
            return true;
        } catch (Exception ex){
            LOGGER.error(ex.getMessage());
            return false;
        }
    }

    public AssetsDto save(AssetsRequest assetsRequest){
        AssetsDto assetsDto = new AssetsDto();
        assetsDto.setUniqueId(assetsRequest.getUniqueId());
        assetsDto.setAssignedUserId(assetsRequest.getAssignedUserId());
        assetsDto.setSerialNumber(assetsRequest.getSerialNumber());
        assetsDto.setModelId(assetsRequest.getModelId());
        assetsDto.setTypeId(assetsRequest.getTypeId());
        assetsDto.setBrandId(assetsRequest.getBrandId());
        assetsDto.setHostName(assetsRequest.getHostName());
        assetsDto.setStateId(assetsRequest.getStateId());
        assetsDto.setMonitorId(assetsRequest.getMonitorId());
        return repository.save(assetsDto)
                .orElseThrow(()->new IllegalStateException(
                        String.valueOf(new MessageResponse("unexpected error!"))));
    }
}
