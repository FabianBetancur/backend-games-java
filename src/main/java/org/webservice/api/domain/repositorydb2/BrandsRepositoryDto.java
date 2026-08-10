package org.webservice.api.domain.repositorydb2;

import org.webservice.api.domain.coredb2.BrandsDto;

import java.util.List;
import java.util.Optional;

public interface BrandsRepositoryDto {
    Optional<List<BrandsDto>> findAll();
    Optional<BrandsDto> save(BrandsDto dto);
}
