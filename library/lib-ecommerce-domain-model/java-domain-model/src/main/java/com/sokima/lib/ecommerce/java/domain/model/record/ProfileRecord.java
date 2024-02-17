package com.sokima.lib.ecommerce.java.domain.model.record;

import com.sokima.lib.ecommerce.java.domain.model.Profile;

public record ProfileRecord(
        Long profileId,
        Long userId
) implements Profile {
}
