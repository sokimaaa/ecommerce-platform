package com.sokima.lib.corelogging.service;

import java.util.List;

public interface MaskedFactory {

    public Masked create(final List<String> fields);
}
