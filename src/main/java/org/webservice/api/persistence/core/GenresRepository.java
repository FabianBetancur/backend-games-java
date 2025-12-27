package org.webservice.api.persistence.core;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.core.GenresDto;
import org.webservice.api.domain.repository.core.GenresRepositoryDto;
import org.webservice.api.persistence.crud.core.GenresCrudRepository;
import org.webservice.api.persistence.entity.core.Genres;
import org.webservice.api.persistence.mapper.core.GenresMapper;

import java.util.List;
import java.util.Optional;
@Repository
@RequiredArgsConstructor
public class GenresRepository implements GenresRepositoryDto {
    private final GenresCrudRepository repository;
    private final GenresMapper mapper;

    @Override
    public Optional<List<GenresDto>> findAll() {
        List<Genres> genresList = (List<Genres>) repository.findAll();
        return Optional.of((List<Genres>) repository.findAll()).map(mapper::toGenresDto);
    }

    @Override
    public Optional<GenresDto> save(GenresDto dto) {
        return Optional.of(repository.save(mapper.toGenres(dto))).map(mapper::toGenresDto);
    }
}
