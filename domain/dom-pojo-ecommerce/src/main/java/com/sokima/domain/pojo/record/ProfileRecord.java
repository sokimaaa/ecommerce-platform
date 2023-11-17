package com.sokima.domain.pojo.record;

import com.sokima.domain.pojo.Profile;

public record ProfileRecord(
        Long profileId,
        Long userId
) implements Profile {
}
