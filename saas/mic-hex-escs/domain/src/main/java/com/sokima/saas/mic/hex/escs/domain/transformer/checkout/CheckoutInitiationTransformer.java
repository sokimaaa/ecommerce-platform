package com.sokima.saas.mic.hex.escs.domain.transformer.checkout;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.ecommerce.proto.domain.model.InitiateOrderCreation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CheckoutInitiationTransformer implements Transformer<Cart, InitiateOrderCreation> {
    private static final Logger log = LoggerFactory.getLogger(CheckoutInitiationTransformer.class);

    @Override
    public InitiateOrderCreation transform(final Cart cart) {
        log.debug("Transforming cart to InitiationOrderCreation : {}", cart);
        return CheckoutInitiationMapper.INSTANCE.transform(cart);
    }
}
