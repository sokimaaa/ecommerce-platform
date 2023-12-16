package com.sokima.saas.mic.hex.escs.domain.model.record;

import com.sokima.saas.mic.hex.escs.domain.model.Cart;

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
