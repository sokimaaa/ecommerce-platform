package com.sokima.lib.ecommerce.java.domain.model.proto;

import com.sokima.lib.ecommerce.proto.domain.model.User;

import java.time.Instant;

public final class UserProto implements com.sokima.lib.ecommerce.java.domain.model.User {
    private final User delegate;

    public UserProto(final User delegate) {
        this.delegate = delegate;
    }

    @Override
    public Instant createdAt() {
        return Instant.ofEpochSecond(delegate.getCreatedAt().getSeconds());
    }

    @Override
    public Long userId() {
        return delegate.getUserId();
    }

    @Override
    public String username() {
        return delegate.getUsername();
    }

    @Override
    public String role() {
        return delegate.getRole();
    }

    @Override
    public String email() {
        return delegate.getEmail();
    }

    @Override
    public String password() {
        return delegate.getPassword();
    }

    @Override
    public Long profileId() {
        return delegate.getProfileId();
    }
}
