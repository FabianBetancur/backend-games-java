package org.webservice.api.persistence.mapper.core;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.webservice.api.domain.core.ShortUrlDto;
import org.webservice.api.persistence.entity.core.ShortUrl;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShortUrlMapper {
    ShortUrlDto toShortUrlDto(ShortUrl shortUrl);
    List<ShortUrlDto> toShortUrlDto(List<ShortUrl> list);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "user",ignore = true)
    })
    ShortUrl toShortUrl(ShortUrlDto shortUrlDto);
}
