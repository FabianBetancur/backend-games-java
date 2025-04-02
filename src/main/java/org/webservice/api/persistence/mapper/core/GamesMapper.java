package org.webservice.api.persistence.mapper.core;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.webservice.api.domain.core.GamesDto;
import org.webservice.api.persistence.entity.core.Games;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GamesMapper {
    GamesDto toGamesDto(Games game);
    List<GamesDto> toGamesDto(List<Games> gamesList);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "genre",ignore = true),
            @Mapping(target = "platform",ignore = true)
    })
    Games toGames(GamesDto gamesDto);
}
