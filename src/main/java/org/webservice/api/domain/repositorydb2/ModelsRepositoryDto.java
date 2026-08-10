package org.webservice.api.domain.repositorydb2;

import org.webservice.api.domain.coredb2.ModelsDto;

import java.util.List;
import java.util.Optional;

public interface ModelsRepositoryDto {
    Optional<List<ModelsDto>> findAll();
    Optional<ModelsDto> save(ModelsDto modelsDto);
}
