package com.sokima.saas.mic.hex.escs.domain.validator;

import com.sokima.saas.mic.hex.escs.domain.model.Cart;

public interface CartRuleValidatorChain {
    boolean validateCart(final Cart cart);
}
