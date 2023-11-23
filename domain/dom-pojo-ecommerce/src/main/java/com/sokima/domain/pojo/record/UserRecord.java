package com.sokima.domain.pojo.record;

import com.sokima.domain.pojo.User;

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
