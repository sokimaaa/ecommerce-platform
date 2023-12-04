package com.sokima.infrastructure.microservice.epgs.config;

import com.sokima.application.microservice.epgs.usecase.TransactionUseCase;
import com.sokima.application.microservice.epgs.usecase.impl.TransactionUseCaseImpl;
import com.sokima.domain.persistent.transaction.adapter.InsertTransactionPersistentAdapter;
import com.sokima.domain.persistent.transaction.adapter.UpdateTransactionPersistentAdapter;
import com.sokima.domain.service.transaction.TransactionService;
import com.sokima.domain.service.transaction.impl.TransactionServiceImpl;
import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionUseCaseConfiguration {

    @UseCase
    TransactionUseCase transactionUseCase(
            final TransactionService transactionService,
            final InsertTransactionPersistentAdapter insertTransactionPersistentAdapter,
            final UpdateTransactionPersistentAdapter updateTransactionPersistentAdapter
    ) {
        return new TransactionUseCaseImpl();
    }

    @DomainService
    TransactionService transactionService(
            final InsertTransactionPersistentAdapter insertTransactionPersistentAdapter,
            final UpdateTransactionPersistentAdapter updateTransactionPersistentAdapter
    ) {
        return new TransactionServiceImpl();
    }
}
