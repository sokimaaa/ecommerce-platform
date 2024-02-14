package com.sokima.lib.corelogging.service.impl;

import java.util.List;

public final class ToStringMask extends GeneralMask {

    private static final String TO_STRING_REPLACEMENT_REGEX = String.format("$1=%s$3", MASK);
    /*
     * (?i): This part is a flag in the regex pattern that enables case-insensitive
     * matching. The (?i) at the beginning of the pattern makes the entire regex
     * match case-insensitive.
     *
     * (%s): This part specifies a placeholder. =: This part matches the equal sign
     * "=" literally.
     *
     * ([^\"]+?(, |\\])|(!#$&\\'+,-./:;<=>?@^_`|~\\(\\)\\{\\}\\w\\d@]*)|((\\d*\\.)?\\d+)|true|false:
     *
     * This part is a set of alternatives separated by the pipe | character,
     * indicating that any of these alternatives can be matched: [^\"]+?(, |\\])):
     * This matches one or more characters that are not double quotes, followed by
     * either a comma and a space , or a backslash \.
     *
     * ([!#$&\\'+,-./:;<=>?@^_`|~\\(\\)\\{\\}\\w\\d@]*): This matches a sequence of characters that can include
     * letters, digits, dots, hyphens, underscores, and special symbols.
     *
     * ((\\d*\\.)?\\d+): This matches a decimal number. Let's break it down further:
     * (\\d*\\.?)?: This matches zero or more digits followed by an optional dot ..
     * The entire group is optional. \\d+: This matches one or more digits.
     *
     * true|false: This matches either the literal string "true" or "false".
     *
     * ([\\s]*): This matches zero or more whitespace characters. In summary, this
     * regex pattern is designed to match key-value pairs where:
     *
     * The key is represented as "%s" followed by an equal sign. The value can be
     * one of the following: A sequence of characters not containing double quotes,
     * followed by either a comma and a space or a backslash. A sequence of
     * characters including letters, digits, dots, hyphens, underscores, and the "@"
     * symbol. A decimal number (with optional decimal part). The literal strings
     * "true" or "false". Whitespace characters are allowed before and after the
     * key-value pair.
     */

    private static final String TO_STRING_PATTERN = "(?i)(%s)=([^\"]+?(, |\\])|([!#$&\\'+,-./:;<=>?@^_`|~\\(\\)\\{\\}\\w\\d]*)|((\\d*\\.)?\\d+)|true|false)([\\s]*)";

    public ToStringMask(final List<String> fields) {

        super(fields, TO_STRING_PATTERN);
    }

    @Override
    public String maskMessage(final String message) {

        return maskMessage(message, TO_STRING_REPLACEMENT_REGEX);
    }

    @Override
    public Object[] maskArguments(Object[] args) {

        return maskArguments(args, TO_STRING_REPLACEMENT_REGEX);
    }
}
