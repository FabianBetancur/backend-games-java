package org.webservice.api.persistence.crud.core;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistence.entity.core.ShortUrl;

import java.util.Optional;

public interface ShortUrlCrudRepository extends CrudRepository<ShortUrl,Long> {
    Optional<ShortUrl> findByShortCode(String code);
}
