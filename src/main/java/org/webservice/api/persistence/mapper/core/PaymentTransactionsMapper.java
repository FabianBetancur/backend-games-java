package org.webservice.api.persistence.mapper.core;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.webservice.api.domain.core.PaymentTransactionsDto;
import org.webservice.api.persistence.entity.core.PaymentTransactions;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentTransactionsMapper {
    PaymentTransactionsDto toDto(PaymentTransactions entity);
    List<PaymentTransactionsDto> toDto(List<PaymentTransactions> list);

    @InheritInverseConfiguration
    PaymentTransactions toEntity(PaymentTransactionsDto dto);
}
