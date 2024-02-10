package com.sokima.saas.mic.hex.escs.infra.adapter.driven.persistent;

import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.ecommerce.java.domain.model.immutable.ImmutableCartImpl;
import com.sokima.lib.hex.architecture.annotation.DrivenAdapter;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.outbound.cart.FindCartPersistentOutPort;
import reactor.core.publisher.Mono;

import java.util.Collections;

@DrivenAdapter
public class FindCartPersistentAdapter implements FindCartPersistentOutPort {
    @Override
    public Mono<Cart> findSingleCart(final Long cartId) {
        return Mono.just(
                ImmutableCartImpl.builder()
                        .cartId(-1L)
                        .userId(-1L)
                        .productIds(Collections.emptySet())
                        .build()
        );
    }
}
