package com.sokima.lib.ecommerce.java.domain.model.record;

import com.sokima.lib.ecommerce.java.domain.model.Method;

public record MethodRecord(
        Long methodId,
        String type
) implements Method {
}
