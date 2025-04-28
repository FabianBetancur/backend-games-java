package org.webservice.api.domain.repository.core;

import org.webservice.api.domain.core.ShortUrlDto;

import java.util.Optional;

public interface ShortUrlRepositoryDto {
    Optional<ShortUrlDto> findByShortCode(String code);
    ShortUrlDto save(ShortUrlDto dto);
}
