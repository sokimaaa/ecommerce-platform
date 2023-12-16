package com.sokima.saas.mic.hex.escs.infra.config;

import com.sokima.saas.mic.hex.escs.usecase.CartUseCase;
import com.sokima.saas.mic.hex.escs.usecase.impl.CartUseCaseImpl;
import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.inbound.cart.InsertCartPersistentInPort;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.inbound.cart.UpdateCartPersistentInPort;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.outbound.cart.FindCartPersistentOutPort;
import com.sokima.saas.mic.hex.escs.domain.service.CartService;
import com.sokima.saas.mic.hex.escs.domain.service.impl.CartServiceImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartUseCaseConfiguration {

    @UseCase
    CartUseCase cartUseCase(
            final CartService cartService,
            final FindCartPersistentOutPort findCartPersistentAdapter,
            final InsertCartPersistentInPort insertCartPersistentAdapter,
            final UpdateCartPersistentInPort updateCartPersistentAdapter
    ) {
        return new CartUseCaseImpl();
    }

    @DomainService
    CartService cartService(
            final FindCartPersistentOutPort findCartPersistentAdapter,
            final InsertCartPersistentInPort insertCartPersistentAdapter,
            final UpdateCartPersistentInPort updateCartPersistentAdapter
    ) {
        return new CartServiceImpl();
    }
}
