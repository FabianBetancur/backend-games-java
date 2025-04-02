package org.webservice.api.persistence.mapper.core;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.core.GenresDto;
import org.webservice.api.persistence.entity.core.Genres;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GenresMapper {
    GenresDto toGenresDto(Genres genres);
    List<GenresDto> toGenresDto(List<Genres> genres);

    @InheritInverseConfiguration
    Genres toGenres(GenresDto genresDto);
}
