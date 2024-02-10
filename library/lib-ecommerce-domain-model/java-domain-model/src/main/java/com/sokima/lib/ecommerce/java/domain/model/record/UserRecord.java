package com.sokima.lib.ecommerce.java.domain.model.record;

import com.sokima.lib.ecommerce.java.domain.model.User;

import java.time.Instant;

public record UserRecord(
        Long userId,
        String username,
        String role,
        String email,
        String password,
        Instant createdAt,
        Long profileId
) implements User {
}
