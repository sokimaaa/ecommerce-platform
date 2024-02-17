package com.sokima.saas.mic.hex.escs.domain.persistent.port.outbound.cart;

import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.hex.architecture.annotation.OutPort;
import reactor.core.publisher.Mono;

@OutPort
public interface FindCartPersistentOutPort {
    Mono<Cart> findSingleCart(final Long cartId);
}
