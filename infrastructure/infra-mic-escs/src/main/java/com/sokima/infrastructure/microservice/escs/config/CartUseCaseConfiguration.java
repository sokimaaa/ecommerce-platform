package com.sokima.infrastructure.microservice.escs.config;

import com.sokima.application.microservice.escs.usecase.CartUseCase;
import com.sokima.application.microservice.escs.usecase.impl.CartUseCaseImpl;
import com.sokima.domain.persistent.cart.adapter.FindCartPersistentAdapter;
import com.sokima.domain.persistent.cart.adapter.InsertCartPersistentAdapter;
import com.sokima.domain.persistent.cart.adapter.UpdateCartPersistentAdapter;
import com.sokima.domain.service.cart.CartService;
import com.sokima.domain.service.cart.impl.CartServiceImpl;
import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartUseCaseConfiguration {

    @UseCase
    CartUseCase cartUseCase(
            final CartService cartService,
            final FindCartPersistentAdapter findCartPersistentAdapter,
            final InsertCartPersistentAdapter insertCartPersistentAdapter,
            final UpdateCartPersistentAdapter updateCartPersistentAdapter
    ) {
        return new CartUseCaseImpl();
    }

    @DomainService
    CartService cartService(
            final FindCartPersistentAdapter findCartPersistentAdapter,
            final InsertCartPersistentAdapter insertCartPersistentAdapter,
            final UpdateCartPersistentAdapter updateCartPersistentAdapter
    ) {
        return new CartServiceImpl();
    }
}
