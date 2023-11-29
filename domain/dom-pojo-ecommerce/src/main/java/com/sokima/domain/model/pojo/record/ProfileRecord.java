package com.sokima.domain.model.pojo.record;

import com.sokima.domain.model.pojo.Profile;

public record ProfileRecord(
        Long profileId,
        Long userId
) implements Profile {
}
