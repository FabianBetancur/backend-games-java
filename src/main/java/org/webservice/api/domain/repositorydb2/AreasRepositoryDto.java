package org.webservice.api.domain.repositorydb2;

import org.webservice.api.domain.coredb2.AreasDto;

import java.util.List;
import java.util.Optional;

public interface AreasRepositoryDto {
    Optional<List<AreasDto>> findAll();
}
