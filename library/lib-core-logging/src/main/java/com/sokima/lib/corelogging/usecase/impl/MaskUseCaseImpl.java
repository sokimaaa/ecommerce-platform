package com.sokima.lib.corelogging.usecase.impl;

import com.sokima.lib.corelogging.usecase.MaskUseCase;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class MaskUseCaseImpl implements MaskUseCase {
    protected static final String MASK = "****";
    private String fieldPattern;
    private Pattern pattern;

    protected MaskUseCaseImpl(List<String> fields, String tamplatePattern) {
        this.fieldPattern = String.join("|", fields);
        this.pattern = Pattern.compile(String.format(tamplatePattern, fieldPattern));
    }

    public String maskMessage(String message, String regex) {
        StringBuffer buffer = new StringBuffer();
        Matcher matcher = pattern.matcher(message);
        while (matcher.find()) {
            matcher.appendReplacement(buffer, regex);
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }
}
