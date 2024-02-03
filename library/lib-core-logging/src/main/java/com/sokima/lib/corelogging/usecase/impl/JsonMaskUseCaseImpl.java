package com.sokima.lib.corelogging.usecase.impl;

import java.util.List;

public class JsonMaskUseCaseImpl extends MaskUseCaseImpl {
    private static final String JSON_REPLACEMENT_REGEX = "\"$1\"$2:$3\"" + MASK + "\"$6";
    private static final String JSON_PATTERN = "\"(%s)\"([\\s]*):([\\s]*)(\"([^\"]+)\"|[\\d]+|true|false|null)([\\s]*)";

    public JsonMaskUseCaseImpl(List<String> fields) {
        super(fields, JSON_PATTERN);
    }

    @Override
    public String maskMessage(String message) {
        return maskMessage(message, JSON_REPLACEMENT_REGEX);
    }
}
