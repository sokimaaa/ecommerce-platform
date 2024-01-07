package com.sokima.saas.mic.hex.escs.domain.persistent.port.outbound.cart;

import com.sokima.lib.hex.architecture.annotation.OutPort;
import com.sokima.saas.mic.hex.escs.domain.model.Cart;
import reactor.core.publisher.Mono;

@OutPort
public interface FindCartPersistentOutPort {

    Mono<Cart> findSingleCart(final Long cartId);

}
