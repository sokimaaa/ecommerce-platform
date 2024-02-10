package com.sokima.saas.mic.hex.escs.domain.validator;

import com.sokima.lib.ecommerce.java.domain.model.Cart;

public interface CartRuleValidatorChain {
    boolean validateCart(final Cart cart);
}
