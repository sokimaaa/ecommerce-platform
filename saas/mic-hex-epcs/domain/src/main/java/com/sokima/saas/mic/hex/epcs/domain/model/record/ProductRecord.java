package com.sokima.saas.mic.hex.epcs.domain.model.record;

import com.sokima.saas.mic.hex.epcs.domain.model.Product;

import java.time.Instant;

public record ProductRecord(
        Long productId,
        String name,
        String description,
        String image,
        Float price,
        String category,
        Instant createdAt,
        Instant updatedAt,
        Long inventoryId
) implements Product {
    @Override
    public String updater() {
        return "owner";
    }
}
