package com.sokima.lib.corelogging.usecase.impl;

import java.util.List;

public class ToStringMaskUseCaseImpl extends MaskUseCaseImpl {
    private static final String TO_STRING_REPLACEMENT_REGEX = "$1=" + MASK + "$3";
    private static final String TO_STRING_PATTERN = "(%s)=([^\"]+?(, |\\)))";

    public ToStringMaskUseCaseImpl(List<String> fields) {
        super(fields, TO_STRING_PATTERN);
    }

    @Override
    public String maskMessage(String message) {
        return maskMessage(message, TO_STRING_REPLACEMENT_REGEX);
    }
}
