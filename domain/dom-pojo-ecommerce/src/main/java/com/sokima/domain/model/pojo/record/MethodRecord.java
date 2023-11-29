package com.sokima.domain.model.pojo.record;

import com.sokima.domain.model.pojo.Method;

public record MethodRecord(
        Long methodId,
        String type
) implements Method {
}
