package com.sokima.saas.mic.hex.escs.domain.validator;

import com.sokima.lib.ecommerce.java.domain.model.Cart;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

public class CartValidatorChain implements CartRuleValidatorChain {

    private static final Logger log = LoggerFactory.getLogger(CartValidatorChain.class);

    private final Set<CartRuleValidatorChain> cartRuleValidatorChain;

    public CartValidatorChain(final Set<CartRuleValidatorChain> cartRuleValidatorChain) {
        this.cartRuleValidatorChain = cartRuleValidatorChain;
    }

    @Override
    public boolean validateCart(final Cart cart) {
        log.info("Launch validator chain for Cart[body={}]", cart);
        return cartRuleValidatorChain.stream().allMatch(x -> x.validateCart(cart));
    }
}
