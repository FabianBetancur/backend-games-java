package org.webservice.api.domain.repositorydb2;

import org.webservice.api.domain.coredb2.CommentsDto;

import java.util.List;
import java.util.Optional;

public interface CommentsRepositoryDto {
    Optional<List<CommentsDto>> findByAssetId(Long id);
    Optional<CommentsDto> save(CommentsDto dto);
}
