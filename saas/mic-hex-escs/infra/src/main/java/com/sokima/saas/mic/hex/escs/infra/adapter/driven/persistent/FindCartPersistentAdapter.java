package com.sokima.saas.mic.hex.escs.infra.adapter.driven.persistent;

import com.sokima.lib.hex.architecture.annotation.DrivenAdapter;
import com.sokima.saas.mic.hex.escs.domain.model.Cart;
import com.sokima.saas.mic.hex.escs.domain.model.record.CartRecord;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.outbound.cart.FindCartPersistentOutPort;
import reactor.core.publisher.Mono;

@DrivenAdapter
public class FindCartPersistentAdapter implements FindCartPersistentOutPort {
    @Override
    public Mono<Cart> findSingleCart(final Long cartId) {
        return Mono.just(
                CartRecord.mock()
        );
    }
}
