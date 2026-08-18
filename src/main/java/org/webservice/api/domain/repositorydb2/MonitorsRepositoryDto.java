package org.webservice.api.domain.repositorydb2;

import org.webservice.api.domain.coredb2.MonitorsDto;

import java.util.List;
import java.util.Optional;

public interface MonitorsRepositoryDto {
    Optional<List<MonitorsDto>> findAll();
    Optional<MonitorsDto> save(MonitorsDto monitorsDto);
}
