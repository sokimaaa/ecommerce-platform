package com.sokima.saas.mic.hex.escs.domain.transformer.clean;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;
import com.sokima.saas.mic.hex.escs.domain.transformer.clean.mapper.Tuple2CleanedCartMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.util.function.Tuple2;

public final class Tuple2CleanedCartTransformer implements Transformer<Tuple2<CleanCartPayload, Cart>, Cart> {

    private static final Logger log = LoggerFactory.getLogger(Tuple2CleanedCartTransformer.class);

    @Override
    public Cart transform(final Tuple2<CleanCartPayload, Cart> input) {

        log.debug("Transforming tuple with CleanCartPayload and Cart: {}", input);
        return Tuple2CleanedCartMapper.INSTANCE.map(input);
    }
}
