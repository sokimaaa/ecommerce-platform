package com.sokima.saas.mic.hex.escs.infra.config;

import com.sokima.lib.hex.architecture.annotation.UseCase;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.inbound.cart.UpdateCartPersistentInPort;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.outbound.cart.FindCartPersistentOutPort;
import com.sokima.saas.mic.hex.escs.usecase.clean.CleanUseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CleanUseCaseConfiguration {

    @UseCase
    CleanUseCase cleanUseCase(
            final FindCartPersistentOutPort findCartPersistentOutPort,
            final UpdateCartPersistentInPort updateCartPersistentInPort
    ) {
        return new CleanUseCase(findCartPersistentOutPort, updateCartPersistentInPort);
    }
}
