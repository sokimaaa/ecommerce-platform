package com.sokima.saas.mic.hex.escs.domain.transformer.checkout;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.proto.domain.model.OrderInitiationResponse;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;

public final class OrderInitiationResponse2CartCleanPayloadTransformer implements Transformer<OrderInitiationResponse, CleanCartPayload> {
    @Override
    public CleanCartPayload transform(final OrderInitiationResponse input) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
