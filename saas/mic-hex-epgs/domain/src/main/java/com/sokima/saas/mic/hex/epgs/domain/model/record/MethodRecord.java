package com.sokima.saas.mic.hex.epgs.domain.model.record;

import com.sokima.saas.mic.hex.epgs.domain.model.Method;

public record MethodRecord(
        Long methodId,
        String type
) implements Method {
}
