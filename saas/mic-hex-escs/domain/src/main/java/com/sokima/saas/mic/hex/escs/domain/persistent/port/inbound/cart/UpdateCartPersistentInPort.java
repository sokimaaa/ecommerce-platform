package com.sokima.saas.mic.hex.escs.domain.persistent.port.inbound.cart;

import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.hex.architecture.annotation.InPort;
import reactor.core.publisher.Mono;

@InPort
public interface UpdateCartPersistentInPort {
    Mono<Cart> updateCart(final Cart cart);
}
