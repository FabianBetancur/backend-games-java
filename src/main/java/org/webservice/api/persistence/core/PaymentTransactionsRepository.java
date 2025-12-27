package org.webservice.api.persistence.core;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.webservice.api.domain.core.PaymentTransactionsDto;
import org.webservice.api.domain.repository.core.PaymentTransactionsRepositoryDto;
import org.webservice.api.persistence.crud.core.PaymentTransactionsCrudRepository;
import org.webservice.api.persistence.entity.core.PaymentTransactions;
import org.webservice.api.persistence.mapper.core.PaymentTransactionsMapper;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PaymentTransactionsRepository implements PaymentTransactionsRepositoryDto {
    private final PaymentTransactionsCrudRepository repository;
    private final PaymentTransactionsMapper mapper;

    @Override
    public Optional<PaymentTransactionsDto> save(PaymentTransactionsDto dto) {
        return Optional.of(repository.save(mapper.toEntity(dto))).map(mapper::toDto);
    }

    @Override
    public Optional<List<PaymentTransactionsDto>> findAll() {
        return Optional.of((List<PaymentTransactions>) repository.findAll()).map(mapper::toDto);
    }
}
