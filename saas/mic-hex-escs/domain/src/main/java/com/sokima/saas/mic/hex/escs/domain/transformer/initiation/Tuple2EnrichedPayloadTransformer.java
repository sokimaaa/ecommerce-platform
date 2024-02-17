package com.sokima.saas.mic.hex.escs.domain.transformer.initiation;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationPayload;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.OrderInitiationPayload;
import reactor.util.function.Tuple2;

public final class Tuple2EnrichedPayloadTransformer implements Transformer<Tuple2<OrderInitiationPayload, Cart>, EnrichedOrderInitiationPayload> {
    @Override
    public EnrichedOrderInitiationPayload transform(final Tuple2<OrderInitiationPayload, Cart> input) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
