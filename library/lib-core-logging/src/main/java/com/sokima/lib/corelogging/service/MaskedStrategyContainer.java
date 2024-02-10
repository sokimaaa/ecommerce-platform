package com.sokima.lib.corelogging.service;

import java.util.List;

public final class MaskedStrategyContainer {

    private List<SupportMasking> masks;

    private Maskable defaultMask;

    public MaskedStrategyContainer(final List<SupportMasking> masks, Maskable defaultMask) {

        this.masks = masks;
        this.defaultMask = defaultMask;
    }

    public Maskable getMask(final String message) {

        for (SupportMasking mask : masks) {
            if (mask.isSupport(message)) {
                return mask;
            }
        }
        return defaultMask;
    }
}
