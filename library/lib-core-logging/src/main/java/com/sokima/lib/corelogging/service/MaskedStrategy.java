package com.sokima.lib.corelogging.service;

import java.util.List;
import java.util.NoSuchElementException;

public final class MaskedStrategy {

    private List<Masked> masks;

    private Masked defaultMask;

    public MaskedStrategy(final List<Masked> masks, Masked defaultMask) {

        this.masks = masks;
        this.defaultMask = defaultMask;
    }

    public Masked getMask(final String message) {

        return masks.stream()
                .filter(m -> m.isSupport(message))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
       /*return masks.stream()
                .filter(m -> m.isSupport(message))
                .findFirst()
                .orElse(defaultMask);*/
    }

    public String getMaskAndApply(final String message) {
        //for ifSupportThenMask method
        return null;
    }
}
