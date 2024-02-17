package com.sokima.lib.ecommerce.java.domain.model.proto;

import com.sokima.lib.ecommerce.proto.domain.model.Profile;

public final class ProfileProto implements com.sokima.lib.ecommerce.java.domain.model.Profile {
    private final Profile delegate;

    public ProfileProto(final Profile delegate) {
        this.delegate = delegate;
    }

    @Override
    public Long profileId() {
        return delegate.getProfileId();
    }

    @Override
    public Long userId() {
        return delegate.getUserId();
    }
}
