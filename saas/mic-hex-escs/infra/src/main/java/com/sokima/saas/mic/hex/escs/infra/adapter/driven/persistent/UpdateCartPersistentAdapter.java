package com.sokima.saas.mic.hex.escs.infra.adapter.driven.persistent;

import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.hex.architecture.annotation.DrivenAdapter;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.inbound.cart.UpdateCartPersistentInPort;
import reactor.core.publisher.Mono;

@DrivenAdapter
public class UpdateCartPersistentAdapter implements UpdateCartPersistentInPort {
    @Override
    public Mono<Cart> updateCart(final Cart cart) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
