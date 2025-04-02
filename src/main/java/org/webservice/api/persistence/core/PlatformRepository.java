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
    private final PlatformsCrudRepository repository;
    private final PlatformsMapper mapper;

    @Autowired
    public PlatformRepository(PlatformsCrudRepository repository, PlatformsMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<PlatformsDto>> findAll() {
        List<Platforms> platformsList = (List<Platforms>) repository.findAll();
        return Optional.of(mapper.toPlatformsDto(platformsList));
    }
}
