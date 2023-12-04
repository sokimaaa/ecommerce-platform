package com.sokima.infrastructure.microservice.epgs.config;

import com.sokima.application.microservice.epgs.usecase.MethodUseCase;
import com.sokima.application.microservice.epgs.usecase.impl.MethodUseCaseImpl;
import com.sokima.domain.persistent.method.adapter.InsertMethodPersistentAdapted;
import com.sokima.domain.service.transaction.MethodService;
import com.sokima.domain.service.transaction.impl.MethodServiceImpl;
import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MethodUseCaseConfiguration {

    @UseCase
    MethodUseCase methodUseCase(
            final MethodService methodService,
            final InsertMethodPersistentAdapted insertMethodPersistentAdapted
    ) {
        return new MethodUseCaseImpl();
    }

    @DomainService
    MethodService methodService(
            final InsertMethodPersistentAdapted insertMethodPersistentAdapted
    ) {
        return new MethodServiceImpl();
    }
}
