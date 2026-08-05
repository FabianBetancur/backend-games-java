package org.webservice.api.domain.repositorydb2;

import org.webservice.api.domain.coredb2.AssetStatesDto;

import java.util.List;
import java.util.Optional;

public interface AssetStatesRepositoryDto {
    Optional<List<AssetStatesDto>> findAll();
}
