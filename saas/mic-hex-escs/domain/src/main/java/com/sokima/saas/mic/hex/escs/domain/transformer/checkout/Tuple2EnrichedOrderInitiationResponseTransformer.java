package com.sokima.saas.mic.hex.escs.domain.transformer.checkout;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.proto.domain.model.OrderInitiationResponse;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationResponse;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.OrderInitiationPayload;
import reactor.util.function.Tuple2;

public final class Tuple2EnrichedOrderInitiationResponseTransformer implements Transformer<Tuple2<OrderInitiationPayload, OrderInitiationResponse>, EnrichedOrderInitiationResponse> {
    @Override
    public EnrichedOrderInitiationResponse transform(final Tuple2<OrderInitiationPayload, OrderInitiationResponse> input) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
