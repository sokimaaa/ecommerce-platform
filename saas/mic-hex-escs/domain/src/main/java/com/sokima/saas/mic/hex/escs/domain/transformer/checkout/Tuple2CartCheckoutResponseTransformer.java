package com.sokima.saas.mic.hex.escs.domain.transformer.checkout;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.proto.domain.model.OrderInitiationResponse;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.response.CartCheckoutResponse;
import com.sokima.saas.mic.hex.escs.spec.rest.manage.v1.response.CartCleanerResponse;
import reactor.util.function.Tuple2;

public final class Tuple2CartCheckoutResponseTransformer implements Transformer<Tuple2<OrderInitiationResponse, CartCleanerResponse>, CartCheckoutResponse> {
    @Override
    public CartCheckoutResponse transform(final Tuple2<OrderInitiationResponse, CartCleanerResponse> input) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
