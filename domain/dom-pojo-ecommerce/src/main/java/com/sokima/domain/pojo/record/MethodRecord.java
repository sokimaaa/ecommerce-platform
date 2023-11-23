package com.sokima.domain.pojo.record;

import com.sokima.domain.pojo.Method;

public record MethodRecord(
        Long methodId,
        String type
) implements Method {
}
