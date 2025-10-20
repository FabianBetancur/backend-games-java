package org.webservice.api.persistence.crud.core;

import org.springframework.data.repository.CrudRepository;
import org.webservice.api.persistence.entity.core.PaymentTransactions;

public interface PaymentTransactionsCrudRepository extends CrudRepository<PaymentTransactions,Long> {
}
