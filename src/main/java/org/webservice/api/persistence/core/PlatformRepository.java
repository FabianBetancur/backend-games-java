package org.webservice.api.persistence.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.core.PlatformsDto;
import org.webservice.api.domain.repository.core.PlatformsRepositoryDto;
import org.webservice.api.persistence.crud.core.PlatformsCrudRepository;
import org.webservice.api.persistence.entity.core.Platforms;
import org.webservice.api.persistence.mapper.core.PlatformsMapper;

import java.util.List;
import java.util.Optional;
@Repository
public class PlatformRepository implements PlatformsRepositoryDto {
    @Autowired
    private PlatformsCrudRepository repository;
    @Autowired
    private PlatformsMapper mapper;

    @Override
    public Optional<List<PlatformsDto>> findAll() {
        return Optional.of((List<Platforms>) repository.findAll()).map(mapper::toPlatformsDto);
    }

    @Override
    public Optional<PlatformsDto> save(PlatformsDto dto) {
        return Optional.of(repository.save(mapper.toPlatforms(dto))).map(mapper::toPlatformsDto);
    }


}
