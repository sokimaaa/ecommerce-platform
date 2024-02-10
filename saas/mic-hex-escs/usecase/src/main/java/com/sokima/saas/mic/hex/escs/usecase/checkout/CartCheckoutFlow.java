package com.sokima.saas.mic.hex.escs.usecase.checkout;

import com.sokima.lib.building.block.flow.Flow;
import reactor.core.publisher.Flux;

public final class CartCheckoutFlow implements Flow {

    private Flow orderInitiationFlow;

    private Flow cartCleanFlow;

    @Override
    public Flux doFlow(Object payload) {
        return null;
    }

    @Override
    public String flow() {
        return "cart-checkout";
    }
}
