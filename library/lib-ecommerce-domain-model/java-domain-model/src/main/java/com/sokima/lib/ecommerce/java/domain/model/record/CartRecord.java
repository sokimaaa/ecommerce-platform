package com.sokima.lib.ecommerce.java.domain.model.record;

import com.sokima.lib.ecommerce.java.domain.model.Cart;

import java.time.Instant;
import java.util.List;
import java.util.Set;

public record CartRecord(
        Long cartId,

        Long userId,

        Instant updatedAt,

        List<Long> productIds
) implements Cart {

    @Override
    public String updater() {
        return "owner";
    }
}
