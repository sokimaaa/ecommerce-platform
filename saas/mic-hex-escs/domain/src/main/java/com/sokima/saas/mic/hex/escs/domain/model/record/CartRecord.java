package com.sokima.saas.mic.hex.escs.domain.model.record;

import com.sokima.saas.mic.hex.escs.domain.model.Cart;

import java.time.Instant;
import java.util.Collections;
import java.util.Set;

public record CartRecord(
        Long cartId,

        Long userId,

        Instant updatedAt,

        Set<Long> productIds
) implements Cart {

    @Override
    public String updater() {
        return "owner";
    }

    public static Cart mock() {
        return new CartRecord(
                -1L,
                -1L,
                Instant.MIN,
                Collections.emptySet()
        );
    }

    public static Cart cleanedCart(final Cart cart) {
        return new CartRecord(
                cart.cartId(),
                cart.userId(),
                Instant.now(),
                Collections.emptySet()
        );
    }
}
