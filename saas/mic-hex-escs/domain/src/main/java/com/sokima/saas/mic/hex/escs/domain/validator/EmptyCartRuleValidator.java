package com.sokima.saas.mic.hex.escs.domain.validator;

import com.sokima.lib.ecommerce.java.domain.model.Cart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmptyCartRuleValidator implements CartRuleValidatorChain {

    private static final Logger log = LoggerFactory.getLogger(EmptyCartRuleValidator.class);

    @Override
    public boolean validateCart(final Cart cart) {
        log.debug("Validate Cart[products={}] is not empty", cart.productIds());
        return !cart.productIds().isEmpty();
    }
}
