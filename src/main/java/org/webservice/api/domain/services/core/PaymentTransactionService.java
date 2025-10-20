package org.webservice.api.domain.services.core;

import jakarta.transaction.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webservice.api.domain.core.PaymentTransactionsDto;
import org.webservice.api.persistence.core.PaymentTransactionsRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaymentTransactionService {
    private final Log LOGGER = LogFactory.getLog(PaymentTransactionService.class);
    @Autowired
    private PaymentTransactionsRepository repository;

    public Optional<PaymentTransactionsDto> save(PaymentTransactionsDto dto){
        return repository.save(dto);
    }

    public Optional<List<PaymentTransactionsDto>> findAll(){
        return repository.findAll();
    }
}
