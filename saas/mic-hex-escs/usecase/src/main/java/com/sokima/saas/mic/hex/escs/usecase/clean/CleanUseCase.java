package com.sokima.saas.mic.hex.escs.usecase.clean;

import com.sokima.saas.mic.hex.escs.domain.model.record.CartRecord;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.inbound.cart.UpdateCartPersistentInPort;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.outbound.cart.FindCartPersistentOutPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public final class CleanUseCase {

    private static final Logger log = LoggerFactory.getLogger(CleanUseCase.class);

    private final FindCartPersistentOutPort findCartPersistent;
    private final UpdateCartPersistentInPort updateCartPersistent;

    public CleanUseCase(final FindCartPersistentOutPort findCartPersistent, final UpdateCartPersistentInPort updateCartPersistent) {
        this.findCartPersistent = findCartPersistent;
        this.updateCartPersistent = updateCartPersistent;
    }

    public Mono<Boolean> clean(final Long cartId) {
        return findCartPersistent.findSingleCart(cartId)
                .map(CartRecord::cleanedCart)
                .doOnNext(cart -> log.debug("Start to clean all products in Cart[cartId={}]", cartId))
                .flatMap(updateCartPersistent::updateCart)
                .map(cleanedCart -> cleanedCart.productIds().isEmpty())
                .doOnNext(isCleaned -> log.info("Cart was clean with Status[boolean={}]", isCleaned));
    }
}
