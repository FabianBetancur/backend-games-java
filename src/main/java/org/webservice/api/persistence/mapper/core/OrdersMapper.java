package org.webservice.api.persistence.mapper.core;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.core.OrdersDto;
import org.webservice.api.persistence.entity.core.Orders;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrdersMapper {
    OrdersDto toDto(Orders entity);
    List<OrdersDto> toDto(List<Orders> list);

    @InheritInverseConfiguration
    Orders toEntity(OrdersDto dto);
}
