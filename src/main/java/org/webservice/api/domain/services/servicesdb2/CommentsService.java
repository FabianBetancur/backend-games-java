package org.webservice.api.domain.services.servicesdb2;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.coredb2.CommentsDto;
import org.webservice.api.domain.dto.db2.CommentRequest;
import org.webservice.api.persistencedb2.CommentsRepository;
import org.webservice.api.web.exceptions.MessageResponse;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentsService {
    private final Log LOGGER = LogFactory.getLog(CommentsService.class);
    private final CommentsRepository repository;

    public Optional<List<CommentsDto>> findByAssetId(Long id){
        return repository.findByAssetId(id);
    }

    public CommentsDto save(CommentRequest request){
        CommentsDto dto = new CommentsDto();
        dto.setContent(request.getContent());
        dto.setAssetId(request.getAssetId());
        return repository.save(dto)
                .orElseThrow(()->new IllegalStateException(
                        String.valueOf(new MessageResponse("unexpected error!"))
                ));
    }

}
