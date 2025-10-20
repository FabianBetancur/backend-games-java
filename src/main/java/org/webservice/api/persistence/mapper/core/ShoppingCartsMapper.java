package org.webservice.api.persistence.mapper.core;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.core.ShoppingCartsDto;
import org.webservice.api.persistence.entity.core.ShoppingCarts;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShoppingCartsMapper {
    ShoppingCartsDto toDto(ShoppingCarts shoppingCarts);
    List<ShoppingCartsDto> toDto(List<ShoppingCarts> list);

    @InheritInverseConfiguration
    ShoppingCarts toEntity(ShoppingCartsDto shoppingCartsDto);
}
