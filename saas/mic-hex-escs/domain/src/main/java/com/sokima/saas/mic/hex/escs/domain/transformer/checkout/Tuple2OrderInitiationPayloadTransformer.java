package com.sokima.saas.mic.hex.escs.domain.transformer.checkout;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.OrderInitiationPayload;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.request.CartCheckoutRequest;
import reactor.util.function.Tuple2;

public final class Tuple2OrderInitiationPayloadTransformer implements Transformer<Tuple2<Long, CartCheckoutRequest>, OrderInitiationPayload> {
    @Override
    public OrderInitiationPayload transform(final Tuple2<Long, CartCheckoutRequest> input) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
