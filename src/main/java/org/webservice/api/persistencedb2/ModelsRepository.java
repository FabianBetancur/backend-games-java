package org.webservice.api.persistencedb2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.coredb2.ModelsDto;
import org.webservice.api.domain.repositorydb2.ModelsRepositoryDto;
import org.webservice.api.persistencedb2.crud.ModelsCrudRepository;
import org.webservice.api.persistencedb2.entity.Models;
import org.webservice.api.persistencedb2.mapper.ModelsMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ModelsRepository implements ModelsRepositoryDto {
    private final ModelsCrudRepository repository;
    private final ModelsMapper mapper;

    @Override
    public Optional<List<ModelsDto>> findAll() {
        return Optional.of((List<Models>) repository.findAll())
                .map(mapper::toModelsDto);
    }
}
