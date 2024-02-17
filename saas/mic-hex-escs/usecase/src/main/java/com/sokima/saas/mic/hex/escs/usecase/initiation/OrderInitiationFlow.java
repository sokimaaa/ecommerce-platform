package com.sokima.saas.mic.hex.escs.usecase.initiation;

import com.sokima.lib.building.block.flow.Flow;
import com.sokima.lib.building.block.sender.RequestMessageSender;
import com.sokima.lib.building.block.transformer.MergingTransformer;
import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.ecommerce.proto.domain.model.OrderInitiationRequest;
import com.sokima.lib.ecommerce.proto.domain.model.OrderInitiationResponse;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationPayload;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.OrderInitiationPayload;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.outbound.cart.FindCartPersistentOutPort;
import com.sokima.saas.mic.hex.escs.domain.validator.CartValidatorChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

public final class OrderInitiationFlow implements Flow<OrderInitiationPayload, OrderInitiationResponse> {

    private static final Logger log = LoggerFactory.getLogger(OrderInitiationFlow.class);

    private final FindCartPersistentOutPort findCartPersistent;
    private final CartValidatorChain cartRuleValidatorChain;
    private final Transformer<Tuple2<OrderInitiationPayload, Cart>, EnrichedOrderInitiationPayload> tuple2EnrichedPayload;
    private final Transformer<EnrichedOrderInitiationPayload, OrderInitiationRequest> enrichedPayload2OrderInitiation;
    private final RequestMessageSender<OrderInitiationRequest, OrderInitiationResponse> orderInitiationSender;

    public OrderInitiationFlow(
            final FindCartPersistentOutPort findCartPersistent,
            final CartValidatorChain cartRuleValidatorChain,
            final Transformer<Tuple2<OrderInitiationPayload, Cart>, EnrichedOrderInitiationPayload> tuple2EnrichedPayload,
            final Transformer<EnrichedOrderInitiationPayload, OrderInitiationRequest> enrichedPayload2OrderInitiation,
            final RequestMessageSender<OrderInitiationRequest, OrderInitiationResponse> orderInitiationSender
    ) {
        this.findCartPersistent = findCartPersistent;
        this.cartRuleValidatorChain = cartRuleValidatorChain;
        this.tuple2EnrichedPayload = tuple2EnrichedPayload;
        this.enrichedPayload2OrderInitiation = enrichedPayload2OrderInitiation;
        this.orderInitiationSender = orderInitiationSender;
    }

    @Override
    public Flux<OrderInitiationResponse> doFlow(final OrderInitiationPayload payload) {
        return Mono.just(payload)
                .doOnNext(p -> log.info("Do order initiation flow with payload: {}", p))
                .flatMap(orderInitiationPayload ->
                        findCartPersistent.findSingleCart(orderInitiationPayload.cartId())
                                .map(cart -> MergingTransformer.merge(orderInitiationPayload, cart))
                )
                .map(tuple2EnrichedPayload::transform)
                .doOnNext(enrichedPayload -> log.debug("Order initiation payload after enrichment: {}", enrichedPayload))
                .filter(enrichedPayload -> cartRuleValidatorChain.validateCart(enrichedPayload.cart()))
                .map(enrichedPayload2OrderInitiation::transform)
                .flatMapMany(orderInitiationSender::send)
                .doOnNext(r -> log.info("Done order initiation flow with response: {}", r));
    }

    @Override
    public String flow() {
        return "order-initiation";
    }
}
