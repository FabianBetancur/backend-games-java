package org.webservice.api.domain.services.core;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.core.ShortUrlDto;
import org.webservice.api.persistence.core.ShortUrlRepository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class ShortUrlService {
    private final Log LOGGER = LogFactory.getLog(ShortUrlService.class);
    private final ShortUrlRepository repository;

    public String shortenUrl(String originalUrl,Long userId){
        String code = generateRandomCode();
        ShortUrlDto shortUrl = new ShortUrlDto();
        shortUrl.setShortCode(code);
        shortUrl.setOriginalUrl(originalUrl);
        shortUrl.setCreatedAt(LocalDateTime.now());
        shortUrl.setUserId(userId);
        repository.save(shortUrl);
        return code;
    }

    public Optional<String> getOriginalUrl(String code){
        return repository.findByShortCode(code).map(ShortUrlDto::getOriginalUrl);
    }

    public String generateRandomCode(){
        return UUID.randomUUID().toString().substring(0,6);
    }
}
