package org.webservice.api.persistencedb2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.coredb2.MonitorsDto;
import org.webservice.api.domain.repositorydb2.MonitorsRepositoryDto;
import org.webservice.api.persistencedb2.crud.MonitorsCrudRepository;
import org.webservice.api.persistencedb2.entity.Monitors;
import org.webservice.api.persistencedb2.mapper.MonitorsMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MonitorsRepository implements MonitorsRepositoryDto {
    private final MonitorsCrudRepository repository;
    private final MonitorsMapper mapper;

    @Override
    public Optional<List<MonitorsDto>> findAll() {
        return Optional.of((List<Monitors>) repository.findAll())
                .map(mapper::toMonitorsDto);
    }

    @Override
    public Optional<MonitorsDto> save(MonitorsDto monitorsDto) {
        return Optional.of(repository.save(mapper.toMonitors(monitorsDto)))
                .map(mapper::toMonitorsDto);
    }
}
