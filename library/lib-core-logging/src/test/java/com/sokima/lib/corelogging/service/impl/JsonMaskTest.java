package com.sokima.lib.corelogging.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sokima.lib.corelogging.service.SupportMasking;

import java.util.List;
import java.util.stream.Stream;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class JsonMaskTest {

    private static final List<String> fields = List.of("email", "password", "phone", "profileId", "totalPrice", "isOver18");

    private static SupportMasking jsonMask;

    @BeforeAll
    static void setUpBeforeClass() {

        jsonMask = new JsonMask(fields);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "{\"id\":123,\"email\":\"test_mail@i.ua\",\"password\":\"test#String_0\",\"isOver18\":true,\"totalPrice\":8.00}"})
    @DisplayName("Validate that reqiered fields in JsonObject are masking")
    void maskMessage_JsonObject_Ok(String correctJsonObject) {

        final String expected = "{\"id\":123,\"email\":\"****\",\"password\":\"****\",\"isOver18\":\"****\",\"totalPrice\":\"****\"}";
        String actual = jsonMask.maskMessage(correctJsonObject);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "[{\"id\":123,\"email\":\"test_mail@i.ua\",\"password\":\"test#String_0\",\"isOver18\":true,\"totalPrice\":8.00}]"})
    @DisplayName("Validate that reqiered fields in JsonArray are masking")
    void maskMessage_JsonArray_Ok(String correctJsonArray) {

        final String expected = "[{\"id\":123,\"email\":\"****\",\"password\":\"****\",\"isOver18\":\"****\",\"totalPrice\":\"****\"}]";
        String actual = jsonMask.maskMessage(correctJsonArray);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"[{\"id\":123,\"preferancedStyle\":\"default\",\"createdAt\":\"1970-01-01T00:00:00Z\"}]"})
    @DisplayName("Validate that JsonObject without requiered fields not masking")
    void maskMessage_JsonObject_NoMatchingFields_Ok(String correctJsonObjectNoMatchingFields) {

        String actual = jsonMask.maskMessage(correctJsonObjectNoMatchingFields);
        assertNotNull(actual);
        assertEquals(correctJsonObjectNoMatchingFields, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "{\"id\":123,\"email\":\"test_mail@i.ua\",\"password\":\"test#String_0\",\"isOver18\":true,\"totalPrice\":8.00}"})
    @DisplayName("Validate that Json Object supported")
    void isSupport_JsonFormatObject_True(String correctJsonObject) {

        assertTrue(jsonMask.isSupport(correctJsonObject));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "[{\"id\":123,\"email\":\"test_mail@i.ua\",\"password\":\"test#String_0\",\"isOver18\":true,\"totalPrice\":8.00}]"})
    @DisplayName("Validate that Json Array supported")
    void isSupport_JsonFormatArray_True(String correctJsonArray) {

        assertTrue(jsonMask.isSupport(correctJsonArray));
    }

    @Test
    @DisplayName("Validate that toString object isn't supported")
    void isSupport_StringFormat_False() {

        final String toStringMessage = "[id=123, email=test_mail@i.ua, password=test#String_0, price=8.00]";
        assertFalse(jsonMask.isSupport(toStringMessage));
    }

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    @DisplayName("Validate that maskArguments in Json format are masking")
    void maskArguments_Array_Ok(List<String> fields, Object[] arguments, Object[] expected) {

        JsonMask maskService = new JsonMask(fields);
        Object[] actual = maskService.maskArguments(arguments);
        assertNotNull(actual);
        assertEquals(String.format("%s", expected), String.format("%s", actual));
    }

    private static Stream<Arguments> argumentsProvider() {

        JSONObject object = new JSONObject(
                "{\"id\":123,\"email\":\"test_mail@i.ua\",\"password\":\"test#String_0\",\"isOver18\":true,\"totalPrice\":8.00}");
        JSONObject maskedObject = new JSONObject(
                "{\"id\":123,\"email\":\"****\",\"password\":\"****\",\"isOver18\":true,\"totalPrice\":8.00}");
        JSONArray jsonArray = new JSONArray(List.of(new JSONObject("{\"id\":123,\"email\":\"test_mail@i.ua\",\"totalPrice\":8.00}"),
                new JSONObject("{}"), new JSONObject("{\"id\":124,\"email\":\"test2_mail@i.ua\",\"totalPrice\":10.20}")));
        String maskedArray = "[{\"totalPrice\":8,\"id\":123,\"email\":\"****\"},{},{\"totalPrice\":10.2,\"id\":124,\"email\":\"****\"}]";
        return Stream.of(Arguments.of(List.of("email", "password", "phone", "profileId"), new Object[] {"{}"}, new Object[] {"{}"}),
                Arguments.of(List.of("email", "password", "phone", "profileId"), new Object[] {List.of(object, object)},
                        new Object[] {List.of(maskedObject, maskedObject)}),
                Arguments.of(List.of("email", "password"), new Object[] {jsonArray}, new Object[] {maskedArray}));
    }
}
