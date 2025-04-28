package org.webservice.api.persistence.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.core.ShortUrlDto;
import org.webservice.api.domain.repository.core.ShortUrlRepositoryDto;
import org.webservice.api.persistence.crud.core.ShortUrlCrudRepository;
import org.webservice.api.persistence.mapper.core.ShortUrlMapper;

import java.util.Optional;
@Repository
public class ShortUrlRepository implements ShortUrlRepositoryDto {
    private final Log LOGGER = LogFactory.getLog(ShortUrlRepository.class);
    @Autowired
    private ShortUrlCrudRepository repository;
    @Autowired
    private ShortUrlMapper mapper;

    @Override
    public Optional<ShortUrlDto> findByShortCode(String code) {
        return repository.findByShortCode(code).map(mapper::toShortUrlDto);
    }

    @Override
    public ShortUrlDto save(ShortUrlDto dto) {
        return mapper.toShortUrlDto(repository.save(mapper.toShortUrl(dto)));
    }
}
