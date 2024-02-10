package com.sokima.lib.corelogging.service.impl;

import com.google.re2j.Matcher;
import com.google.re2j.Pattern;
import com.sokima.lib.corelogging.service.Masked;

import java.util.List;

public abstract class GeneralMask implements Masked {

    protected static final String MASK = "****";

    private String fieldPattern;

    private String tamplatePattern;

    protected GeneralMask(List<String> fields, String tamplatePattern) {

        this.fieldPattern = String.join("|", fields);
        this.tamplatePattern = tamplatePattern;
    }

    public String maskMessage(final String message, final String regex) {

        final Matcher matcher = Pattern.compile(String.format(tamplatePattern, fieldPattern)).matcher(message);
        if (matcher.find()) {
            return matcher.replaceAll(regex);
        }
        return message;
    }
}
