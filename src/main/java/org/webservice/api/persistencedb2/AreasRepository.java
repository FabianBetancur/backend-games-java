package org.webservice.api.persistencedb2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.coredb2.AreasDto;
import org.webservice.api.domain.repositorydb2.AreasRepositoryDto;
import org.webservice.api.persistencedb2.crud.AreasCrudRepository;
import org.webservice.api.persistencedb2.entity.Areas;
import org.webservice.api.persistencedb2.mapper.AreasMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AreasRepository implements AreasRepositoryDto {
    private final AreasCrudRepository repository;
    private final AreasMapper mapper;

    @Override
    public Optional<List<AreasDto>> findAll() {
        return Optional.of((List<Areas>) repository.findAll())
                .map(mapper::toAreasDto);
    }
}
