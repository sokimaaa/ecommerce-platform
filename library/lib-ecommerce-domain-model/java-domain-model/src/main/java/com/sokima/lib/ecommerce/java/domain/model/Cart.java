package com.sokima.lib.ecommerce.java.domain.model;

import java.io.Serializable;
import java.util.Set;

public interface Cart extends Updatable, Serializable {
    /**
     * the cart unique identifier.
     *
     * @return the cart id
     */
    Long cartId();

    /**
     * the owner of cart.
     *
     * @return the user id
     */
    Long userId();

    /**
     * the product ids that added to cart.
     *
     * @return the product ids
     */
    Set<Long> productIds();
}
