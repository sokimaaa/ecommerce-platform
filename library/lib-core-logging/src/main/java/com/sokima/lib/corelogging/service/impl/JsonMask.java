package com.sokima.lib.corelogging.service.impl;

import com.sokima.lib.corelogging.service.SupportMasking;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsonMask extends GeneralMask implements SupportMasking {

    private static final String JSON_REPLACEMENT_REGEX = String.format("\"$1\"$2:$3\"%s\"$6", MASK);

    /*
     * \"(?i)(%s)\":
     *
     * \": This matches a double quote character " in the input string. (?i): This
     * is a flag in the regex pattern that enables case-insensitive matching. (%s):
     * This part captures the literal characters "%s" in a case-insensitive manner,
     * enclosed within double quotes.
     *
     * ([\\s]*):([\\s]*):
     *
     * ([\\s]*): This captures zero or more whitespace characters. :: This matches a
     * colon character : in the input string. ([\\s]*): This captures zero or more
     * whitespace characters.
     *
     * ((\"([^\"]+?)\")|([\\d]+(?:\\.[\\d]*)?)|true|false|null):
     *
     * This part is a set of alternatives separated by the pipe | character,
     * indicating that any of these alternatives can be matched:
     *
     * (\"([^\"]+?)\"): This captures a sequence of characters enclosed within
     * double quotes. Let's break it down further:
     * \": This matches a double quote character " in the input string. ([^\"]+?):
     * This part matches one or more characters that are not double quotes in a
     * non-greedy manner. \": This matches a closing double quote character " in the
     * input string.
     *
     * [\\d]+(?:\\.[\\d]*)?: This matches a decimal number, allowing for an optional
     * decimal part. Let's break it down further: [\\d]+: This matches one or more
     * digits. (?:\\.[\\d]*)?: This non-capturing group matches an optional decimal
     * part. It starts with a dot \\. followed by zero or more digits [\\d]*.
     *
     * true|false|null: This matches the literal strings "true", "false", or "null".
     *
     * ([\\s]*): This part captures zero or more whitespace characters.
     *
     * In summary, the regex pattern is designed to match key-value pairs in a
     * JSON-like structure where: The key is represented as "%s" enclosed within
     * double quotes. After the key, there's a colon : followed by the value. The
     * value can be enclosed within double quotes, a decimal number (with optional
     * decimal part), or one of the literals "true", "false", or "null". Whitespace
     * characters are allowed before and after the key-value pair.
     */
    private static final String JSON_PATTERN = "\"(?i)(%s)\"([\\s]*):([\\s]*)(\"([^\"]+?)\"|[\\d]+(?:\\.[\\d]*)?|true|false|null)([\\s]*)";

    public JsonMask(final List<String> fields) {

        super(fields, JSON_PATTERN);
    }

    @Override
    public String maskMessage(final String message) {

        return maskMessage(message, JSON_REPLACEMENT_REGEX);
    }

    @Override
    public Object[] maskArguments(final Object[] args) {

        return maskArguments(args, JSON_REPLACEMENT_REGEX);
    }

    @Override
    public boolean isSupport(final String message) {

        try {
            new JSONObject(message);
        } catch (JSONException e) {
            try {
                new JSONArray(message);
            } catch (JSONException ne) {
                return false;
            }
        }
        return true;
    }
}
