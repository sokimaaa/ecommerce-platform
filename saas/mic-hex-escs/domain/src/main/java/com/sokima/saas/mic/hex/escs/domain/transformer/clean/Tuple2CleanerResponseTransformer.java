package com.sokima.saas.mic.hex.escs.domain.transformer.clean;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;
import com.sokima.saas.mic.hex.escs.domain.transformer.clean.mapper.Tuple2CleanerResponseMapper;
import com.sokima.saas.mic.hex.escs.spec.rest.manage.v1.response.CartCleanerResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import reactor.util.function.Tuple2;

public final class Tuple2CleanerResponseTransformer implements Transformer<Tuple2<CleanCartPayload, Cart>, CartCleanerResponse> {

    private static final Logger log = LoggerFactory.getLogger(Tuple2CleanerResponseTransformer.class);

    @Override
    public CartCleanerResponse transform(final Tuple2<CleanCartPayload, Cart> input) {
        log.debug("Transforming tuple with CleanCartPayload and Cart: {}", input);
        return Tuple2CleanerResponseMapper.INSTANCE.map(input);
    }
}
