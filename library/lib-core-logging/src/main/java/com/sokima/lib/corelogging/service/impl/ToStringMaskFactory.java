package com.sokima.lib.corelogging.service.impl;

import com.sokima.lib.corelogging.service.Masked;
import com.sokima.lib.corelogging.service.MaskedFactory;

import java.util.List;

public final class ToStringMaskFactory implements MaskedFactory {

    @Override
    public Masked create(final List<String> fields) {

        return new ToStringMask(fields);
    }
}
