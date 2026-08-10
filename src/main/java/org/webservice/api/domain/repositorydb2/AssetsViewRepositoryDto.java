package org.webservice.api.domain.repositorydb2;

import org.webservice.api.domain.coredb2.AssetsViewDto;

import java.util.List;
import java.util.Optional;

public interface AssetsViewRepositoryDto {
    Optional<List<AssetsViewDto>> findAll();
}
