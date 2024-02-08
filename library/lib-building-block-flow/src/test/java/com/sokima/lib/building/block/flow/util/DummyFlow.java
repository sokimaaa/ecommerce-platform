package com.sokima.lib.building.block.flow.util;

import com.sokima.lib.building.block.flow.Flow;
import reactor.core.publisher.Flux;

public final class DummyFlow implements Flow<Object, Object> {
    @Override
    public Flux<Object> doFlow(final Object payload) {
        throw new UnsupportedOperationException("DummyFlow#doFlow");
    }

    @Override
    public String flow() {
        throw new UnsupportedOperationException("DummyFlow#flow");
    }
}
