package com.sokima.saas.mic.hex.escs.domain.transformer.clean;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;
import reactor.util.function.Tuple2;

public final class Tuple2CleanedCartTransformer implements Transformer<Tuple2<CleanCartPayload, Cart>, Cart> {
    @Override
    public Cart transform(final Tuple2<CleanCartPayload, Cart> input) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
