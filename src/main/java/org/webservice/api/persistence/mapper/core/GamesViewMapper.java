package org.webservice.api.persistence.mapper.core;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.core.GamesViewDto;
import org.webservice.api.persistence.entity.core.GamesView;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GamesViewMapper {
    GamesViewDto toGamesViewDto (GamesView gamesView);
    List<GamesViewDto> toGamesViewDto (List<GamesView> gamesViewList);

    @InheritInverseConfiguration
    GamesView toGamesView(GamesViewDto gamesViewDto);
}
