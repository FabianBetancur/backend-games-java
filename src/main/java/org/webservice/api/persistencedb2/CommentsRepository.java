package org.webservice.api.persistencedb2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.coredb2.CommentsDto;
import org.webservice.api.domain.repositorydb2.CommentsRepositoryDto;
import org.webservice.api.persistencedb2.crud.CommentsCrudRepository;
import org.webservice.api.persistencedb2.mapper.CommentsMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CommentsRepository implements CommentsRepositoryDto {
    private final CommentsCrudRepository repository;
    private final CommentsMapper mapper;

    @Override
    public Optional<List<CommentsDto>> findByAssetId(Long id) {
        return repository.findByAssetId(id).map(mapper::toCommentsDto);
    }

    @Override
    public Optional<CommentsDto> save(CommentsDto dto) {
        return Optional.of(repository.save(mapper.toComments(dto)))
                .map(mapper::toCommentsDto);
    }
}
