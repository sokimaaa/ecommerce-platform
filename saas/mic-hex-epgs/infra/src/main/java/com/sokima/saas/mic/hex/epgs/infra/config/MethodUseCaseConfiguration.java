package com.sokima.saas.mic.hex.epgs.infra.config;

import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import com.sokima.saas.mic.hex.epgs.domain.persistent.port.inbound.method.InsertMethodPersistentInPort;
import com.sokima.saas.mic.hex.epgs.domain.service.MethodService;
import com.sokima.saas.mic.hex.epgs.domain.service.impl.MethodServiceImpl;
import com.sokima.saas.mic.hex.epgs.usecase.MethodUseCase;
import com.sokima.saas.mic.hex.epgs.usecase.impl.MethodUseCaseImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MethodUseCaseConfiguration {

    @UseCase
    MethodUseCase methodUseCase(
            final MethodService methodService,
            final InsertMethodPersistentInPort insertMethodPersistentAdapted
    ) {
        return new MethodUseCaseImpl();
    }

    @DomainService
    MethodService methodService(
            final InsertMethodPersistentInPort insertMethodPersistentAdapted
    ) {
        return new MethodServiceImpl();
    }
}
