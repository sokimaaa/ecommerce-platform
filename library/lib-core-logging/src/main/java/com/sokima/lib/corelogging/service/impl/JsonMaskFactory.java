package com.sokima.lib.corelogging.service.impl;

import com.sokima.lib.corelogging.service.MaskedFactory;
import com.sokima.lib.corelogging.service.SupportMasking;

import java.util.List;

public final class JsonMaskFactory implements MaskedFactory {

    @Override
    public SupportMasking create(final List<String> fields) {

        return new JsonMask(fields);
    }
}
