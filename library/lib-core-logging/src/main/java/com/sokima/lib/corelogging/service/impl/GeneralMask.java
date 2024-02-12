package com.sokima.lib.corelogging.service.impl;

import com.google.re2j.Matcher;
import com.google.re2j.Pattern;
import com.sokima.lib.corelogging.service.Maskable;

import java.util.List;

public abstract class GeneralMask implements Maskable {

    protected static final String MASK = "****";

    private String fieldPattern;
    
    private Pattern pattern;

    protected GeneralMask(List<String> fields, String tamplatePattern) {

        this.fieldPattern = String.join("|", fields);
        this.pattern = Pattern.compile(String.format(tamplatePattern, fieldPattern));
    }

    public String maskMessage(final String message, final String regex) {
        final Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            return matcher.replaceAll(regex);
        }
        return message;
    }
}
