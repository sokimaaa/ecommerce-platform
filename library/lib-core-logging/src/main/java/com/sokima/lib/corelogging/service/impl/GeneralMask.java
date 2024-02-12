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

    public Object[] maskArguments(final Object[] args, final String regex) {

        Matcher matcher;
        String[] maskedArgs = new String[args.length];
        for (int i = 0; i < args.length; i++) {
            matcher = pattern.matcher(args[i].toString());
            if (matcher.find()) {
                maskedArgs[i] = matcher.replaceAll(regex);
            } else {
                maskedArgs[i] = args[i].toString();
            }
        }
        return maskedArgs;
    }
}
