package org.webservice.api.persistence.core;

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
public class GenresRepository implements GenresRepositoryDto {
    private final GenresCrudRepository repository;
    private final GenresMapper mapper;

    @Autowired
    public GenresRepository(GenresCrudRepository repository, GenresMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<GenresDto>> findAll() {
        List<Genres> genresList = (List<Genres>) repository.findAll();
        return Optional.of(mapper.toGenresDto(genresList));
    }
}
