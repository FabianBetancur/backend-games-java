package org.webservice.api.persistence.mapper.core;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.core.GamesInventoryDto;
import org.webservice.api.persistence.entity.core.GamesInventory;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameInventoryMapper {
    GamesInventoryDto toGamesInventoryDto (GamesInventory gamesInventory);
    List<GamesInventoryDto> toGamesInventoryDto (List<GamesInventory> gamesInventoryList);

    @InheritInverseConfiguration
    GamesInventory toGamesInventory (GamesInventoryDto gamesInventoryDto);
}
