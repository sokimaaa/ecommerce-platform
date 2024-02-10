package com.sokima.saas.mic.hex.escs.usecase.clean;

import com.sokima.lib.building.block.flow.Flow;
import reactor.core.publisher.Flux;

public final class CartCleanFlow implements Flow {
    @Override
    public Flux doFlow(Object payload) {
        return null;
    }

    @Override
    public String flow() {
        return "cart-clean";
    }
}
