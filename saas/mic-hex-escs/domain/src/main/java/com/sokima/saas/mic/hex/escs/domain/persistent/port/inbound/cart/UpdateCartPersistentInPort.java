package com.sokima.saas.mic.hex.escs.domain.persistent.port.inbound.cart;

import com.sokima.lib.hex.architecture.annotation.InPort;
import com.sokima.saas.mic.hex.escs.domain.model.Cart;
import reactor.core.publisher.Mono;

@InPort
public interface UpdateCartPersistentInPort {
    Mono<Cart> updateCart(final Cart cart);
}
