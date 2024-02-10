package com.sokima.saas.mic.hex.escs.usecase.clean;

import com.sokima.lib.ecommerce.java.domain.model.immutable.ImmutableCartImpl;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.inbound.cart.UpdateCartPersistentInPort;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.outbound.cart.FindCartPersistentOutPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.Collections;

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
                .map(cart -> ImmutableCartImpl.builder() // todo: create unary mapping Cart -> CleanedCart
                        .cartId(cart.cartId())
                        .userId(cart.userId())
                        .productIds(Collections.emptySet())
                        .build()
                )
                .doOnNext(cart -> log.debug("Start to clean all products in Cart[cartId={}]", cartId))
                .flatMap(updateCartPersistent::updateCart)
                .map(cleanedCart -> cleanedCart.productIds().isEmpty())
                .doOnNext(isCleaned -> log.info("Cart was clean with Status[boolean={}]", isCleaned));
    }
}
