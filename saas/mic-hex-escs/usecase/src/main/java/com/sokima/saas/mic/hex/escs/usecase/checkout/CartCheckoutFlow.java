package com.sokima.saas.mic.hex.escs.usecase.checkout;

import com.sokima.lib.building.block.flow.BiFlow;
import com.sokima.lib.building.block.flow.Flow;
import com.sokima.lib.building.block.transformer.MergingTransformer;
import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationResponse;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.OrderInitiationPayload;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.request.CartCheckoutRequest;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.response.CartCheckoutResponse;
import com.sokima.saas.mic.hex.escs.spec.rest.manage.v1.response.CartCleanerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

public final class CartCheckoutFlow implements BiFlow<Long, CartCheckoutRequest, CartCheckoutResponse> {

    private static final Logger log = LoggerFactory.getLogger(CartCheckoutFlow.class);

    private final Flow<OrderInitiationPayload, EnrichedOrderInitiationResponse> orderInitiationEnrichedFlow;
    private final Flow<CleanCartPayload, CartCleanerResponse> cartCleanFlow;
    private final Transformer<Tuple2<Long, CartCheckoutRequest>, OrderInitiationPayload> tuple2OrderInitiationPayload;
    private final Transformer<EnrichedOrderInitiationResponse, CleanCartPayload> orderInitiationResponse2CartCleanPayload;
    private final Transformer<Tuple2<EnrichedOrderInitiationResponse, CartCleanerResponse>, CartCheckoutResponse> tuple2CartCheckoutResponse;

    public CartCheckoutFlow(
            final Flow<OrderInitiationPayload, EnrichedOrderInitiationResponse> orderInitiationEnrichedFlow,
            final Flow<CleanCartPayload, CartCleanerResponse> cartCleanFlow,
            final Transformer<Tuple2<Long, CartCheckoutRequest>, OrderInitiationPayload> tuple2OrderInitiationPayload,
            final Transformer<EnrichedOrderInitiationResponse, CleanCartPayload> orderInitiationResponse2CartCleanPayload,
            final Transformer<Tuple2<EnrichedOrderInitiationResponse, CartCleanerResponse>, CartCheckoutResponse> tuple2CartCheckoutResponse
    ) {
        this.orderInitiationEnrichedFlow = orderInitiationEnrichedFlow;
        this.cartCleanFlow = cartCleanFlow;
        this.tuple2OrderInitiationPayload = tuple2OrderInitiationPayload;
        this.orderInitiationResponse2CartCleanPayload = orderInitiationResponse2CartCleanPayload;
        this.tuple2CartCheckoutResponse = tuple2CartCheckoutResponse;
    }

    @Override
    public Flux<CartCheckoutResponse> doFlow(final Tuple2<Long, CartCheckoutRequest> payload) {
        return Mono.just(payload)
                .doOnNext(p -> log.info("Do cart checkout flow with payload: {}", p))
                .map(tuple2OrderInitiationPayload::transform)
                .flatMapMany(orderInitiationEnrichedFlow::doFlow)
                .singleOrEmpty()
                .filter(EnrichedOrderInitiationResponse::ok)
                .flatMapMany(orderInitiationResponse -> {
                    final CleanCartPayload cleanCartPayload = orderInitiationResponse2CartCleanPayload.transform(orderInitiationResponse);
                    return cartCleanFlow.doFlow(cleanCartPayload)
                            .map(cleanResponse -> MergingTransformer.merge(orderInitiationResponse, cleanResponse));
                })
                .map(tuple2CartCheckoutResponse::transform)
                .doOnNext(r -> log.info("Done cart checkout flow with response: {}", r));
    }

    @Override
    public String flow() {
        return "cart-checkout";
    }
}
