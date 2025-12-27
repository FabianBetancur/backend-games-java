package org.webservice.api.persistence.core;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class ShortUrlRepository implements ShortUrlRepositoryDto {
    private final Log LOGGER = LogFactory.getLog(ShortUrlRepository.class);
    private final ShortUrlCrudRepository repository;
    private final ShortUrlMapper mapper;

    @Override
    public Optional<ShortUrlDto> findByShortCode(String code) {
        return repository.findByShortCode(code).map(mapper::toShortUrlDto);
    }

    @Override
    public Optional<ShortUrlDto> save(ShortUrlDto dto) {
        return Optional.of(repository.save(mapper.toShortUrl(dto))).map(mapper::toShortUrlDto);
    }
}
