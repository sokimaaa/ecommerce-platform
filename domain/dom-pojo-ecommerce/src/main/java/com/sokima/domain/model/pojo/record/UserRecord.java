package com.sokima.domain.model.pojo.record;

import com.sokima.domain.model.pojo.User;

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
