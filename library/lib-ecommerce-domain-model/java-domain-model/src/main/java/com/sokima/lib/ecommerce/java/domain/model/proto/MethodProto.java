package com.sokima.lib.ecommerce.java.domain.model.proto;

import com.sokima.lib.ecommerce.proto.domain.model.Method;

public final class MethodProto implements com.sokima.lib.ecommerce.java.domain.model.Method {
    private final Method delegate;

    public MethodProto(final Method delegate) {
        this.delegate = delegate;
    }

    @Override
    public Long methodId() {
        return delegate.getMethodId();
    }

    @Override
    public String type() {
        return delegate.getType();
    }
}
