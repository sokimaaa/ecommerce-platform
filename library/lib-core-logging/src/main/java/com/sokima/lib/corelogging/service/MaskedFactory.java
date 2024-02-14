package com.sokima.lib.corelogging.service;

import java.util.List;

public interface MaskedFactory {

    SupportMasking create(final List<String> fields);
}
