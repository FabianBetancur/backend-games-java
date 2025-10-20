package org.webservice.api.persistence.mapper.core;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.webservice.api.domain.core.CartItemsDto;
import org.webservice.api.persistence.entity.core.CartItems;

import java.util.List;

@Mapper(componentModel = "spring",uses = {ShoppingCartsMapper.class, GamesViewMapper.class})
public interface CartItemsMapper {
    CartItemsDto toDto(CartItems entity);
    List<CartItemsDto> toDto(List<CartItems> list);

    @InheritInverseConfiguration
    CartItems toEntity(CartItemsDto cartItemsDto);
}
