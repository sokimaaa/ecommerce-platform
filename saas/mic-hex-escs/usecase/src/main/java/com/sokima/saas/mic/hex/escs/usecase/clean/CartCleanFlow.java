package com.sokima.saas.mic.hex.escs.usecase.clean;

import com.sokima.lib.building.block.flow.Flow;
import com.sokima.lib.building.block.transformer.MergingTransformer;
import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.inbound.cart.UpdateCartPersistentInPort;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.outbound.cart.FindCartPersistentOutPort;
import com.sokima.saas.mic.hex.escs.spec.rest.manage.v1.response.CartCleanerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

public final class CartCleanFlow implements Flow<CleanCartPayload, CartCleanerResponse> {

    private static final Logger log = LoggerFactory.getLogger(CartCleanFlow.class);

    private final FindCartPersistentOutPort findCartPersistent;
    private final UpdateCartPersistentInPort updateCartPersistent;
    private final Transformer<Tuple2<CleanCartPayload, Cart>, Cart> tuple2CleanedCart;
    private final Transformer<Tuple2<CleanCartPayload, Cart>, CartCleanerResponse> tuple2CleanerResponse;

    public CartCleanFlow(
            final FindCartPersistentOutPort findCartPersistent,
            final UpdateCartPersistentInPort updateCartPersistent,
            final Transformer<Tuple2<CleanCartPayload, Cart>, Cart> tuple2CleanedCart,
            final Transformer<Tuple2<CleanCartPayload, Cart>, CartCleanerResponse> tuple2CleanerResponse
    ) {
        this.findCartPersistent = findCartPersistent;
        this.updateCartPersistent = updateCartPersistent;
        this.tuple2CleanedCart = tuple2CleanedCart;
        this.tuple2CleanerResponse = tuple2CleanerResponse;
    }

    @Override
    public Flux<CartCleanerResponse> doFlow(final CleanCartPayload payload) {
        return Mono.just(payload)
                .doOnNext(p -> log.info("Do cart clean flow with payload: {}", p))
                .flatMap(
                        cleanCartPayload -> findCartPersistent.findSingleCart(cleanCartPayload.cartId()).map(
                                cart -> MergingTransformer.merge(cleanCartPayload, cart)
                        )
                )
                .flatMapMany(
                        tuple -> {
                            final Cart cleanedCart = tuple2CleanedCart.transform(tuple);
                            return updateCartPersistent.updateCart(cleanedCart)
                                    .map(updatedCart -> MergingTransformer.merge(tuple.getT1(), updatedCart));
                        }
                )
                .map(tuple2CleanerResponse::transform)
                .doOnNext(r -> log.info("Done cart clean flow with response: {}", r));
    }

    @Override
    public String flow() {
        return "cart-clean";
    }
}
