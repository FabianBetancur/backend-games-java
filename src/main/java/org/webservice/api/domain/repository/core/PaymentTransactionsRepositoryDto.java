package org.webservice.api.domain.repository.core;

import org.webservice.api.domain.core.PaymentTransactionsDto;

import java.util.List;
import java.util.Optional;

public interface PaymentTransactionsRepositoryDto {
    Optional<PaymentTransactionsDto> save(PaymentTransactionsDto dto);
    Optional<List<PaymentTransactionsDto>> findAll();
}
