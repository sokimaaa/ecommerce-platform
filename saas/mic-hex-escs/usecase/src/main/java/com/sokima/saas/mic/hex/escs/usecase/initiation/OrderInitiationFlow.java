package com.sokima.saas.mic.hex.escs.usecase.initiation;

import com.sokima.lib.building.block.flow.Flow;
import com.sokima.lib.building.block.sender.RequestMessageSender;
import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.ecommerce.proto.domain.model.CompletionOrderCreation;
import com.sokima.lib.ecommerce.proto.domain.model.InitiateOrderCreation;
import reactor.core.publisher.Flux;

public final class OrderInitiationFlow implements Flow<InitiateOrderCreation, CompletionOrderCreation> {

    private Transformer<Cart, InitiateOrderCreation> orderInitiationTransformer;

    private RequestMessageSender<InitiateOrderCreation, CompletionOrderCreation> sender;

    @Override
    public Flux<CompletionOrderCreation> doFlow(final InitiateOrderCreation payload) {
        return sender.send(payload);
    }

    @Override
    public String flow() {
        return "order-initiation";
    }
}
