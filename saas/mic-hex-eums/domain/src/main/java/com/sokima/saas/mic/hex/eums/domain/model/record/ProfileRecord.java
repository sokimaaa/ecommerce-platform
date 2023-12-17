package com.sokima.saas.mic.hex.eums.domain.model.record;

import com.sokima.saas.mic.hex.eums.domain.model.Profile;

public record ProfileRecord(
        Long profileId,
        Long userId
) implements Profile {
}
