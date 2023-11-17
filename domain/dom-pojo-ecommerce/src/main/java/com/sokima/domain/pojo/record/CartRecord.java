package com.sokima.domain.pojo.record;

import com.sokima.domain.pojo.Cart;

import java.time.Instant;
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
}
