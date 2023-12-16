package com.sokima.saas.mic.hex.epgs.infra.config;

import com.sokima.saas.mic.hex.epgs.usecase.TransactionUseCase;
import com.sokima.saas.mic.hex.epgs.usecase.impl.TransactionUseCaseImpl;
import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import com.sokima.saas.mic.hex.epgs.domain.persistent.port.inbound.transaction.InsertTransactionPersistentInPort;
import com.sokima.saas.mic.hex.epgs.domain.persistent.port.inbound.transaction.UpdateTransactionPersistentInPort;
import com.sokima.saas.mic.hex.epgs.domain.service.TransactionService;
import com.sokima.saas.mic.hex.epgs.domain.service.impl.TransactionServiceImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionUseCaseConfiguration {

    @UseCase
    TransactionUseCase transactionUseCase(
            final TransactionService transactionService,
            final InsertTransactionPersistentInPort insertTransactionPersistentAdapter,
            final UpdateTransactionPersistentInPort updateTransactionPersistentAdapter
    ) {
        return new TransactionUseCaseImpl();
    }

    @DomainService
    TransactionService transactionService(
            final InsertTransactionPersistentInPort insertTransactionPersistentAdapter,
            final UpdateTransactionPersistentInPort updateTransactionPersistentAdapter
    ) {
        return new TransactionServiceImpl();
    }
}
