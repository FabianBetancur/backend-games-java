package org.webservice.api.domain.services.core;

import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.core.GenresDto;
import org.webservice.api.persistence.core.GenresRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GenreService {
    private final Log LOGGER = LogFactory.getLog(GenreService.class);
    private final GenresRepository repository;

    @Autowired
    public GenreService(GenresRepository repository) {
        this.repository = repository;
    }

    public Optional<List<GenresDto>> findAll(){
        return repository.findAll();
    }

    public GenresDto save(GenresDto genresDto){
        return repository.save(genresDto);
    }
}
