package com.sokima.saas.mic.hex.escs.infra.adapter.driven.persistent;

import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.hex.architecture.annotation.DrivenAdapter;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.outbound.cart.FindCartPersistentOutPort;
import reactor.core.publisher.Mono;

@DrivenAdapter
public class FindCartPersistentAdapter implements FindCartPersistentOutPort {
    @Override
    public Mono<Cart> findSingleCart(final Long cartId) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
