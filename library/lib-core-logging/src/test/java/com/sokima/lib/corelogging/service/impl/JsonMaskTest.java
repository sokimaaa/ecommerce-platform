package com.sokima.lib.corelogging.service.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sokima.lib.corelogging.service.SupportMasking;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JsonMaskTest {

    private static final List<String> fields = List.of("email", "password", "phone", "profileId", "totalPrice", "isOver18");

    private static final String correctJsonObject = "{\"id\":123,\"email\":\"test_mail@i.ua\",\"password\":\"test#String_0\",\"isOver18\":true,\"totalPrice\":8.00}";

    private static final String correctJsonObjectNoMatchingFields = "[{\"id\":123,\"preferancedStyle\":\"default\",\"createdAt\":\"1970-01-01T00:00:00Z\"}]";

    private static final String correctJsonArray = "[{\"id\":123,\"email\":\"test_mail@i.ua\",\"password\":\"test#String_0\",\"isOver18\":true,\"totalPrice\":8.00}]";

    private static SupportMasking jsonMask;

    @BeforeAll
    static void setUpBeforeClass() {

        jsonMask = new JsonMask(fields);
    }

    @Test
    @DisplayName("Validate that reqiered fields in JsonObject are masking")
    void maskMessage_JsonObject_Ok() {

        final String expected = "{\"id\":123,\"email\":\"****\",\"password\":\"****\",\"isOver18\":\"****\",\"totalPrice\":\"****\"}";
        String actual = jsonMask.maskMessage(correctJsonObject);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Validate that reqiered fields in JsonArray are masking")
    void maskMessage_JsonArray_Ok() {

        final String expected = "[{\"id\":123,\"email\":\"****\",\"password\":\"****\",\"isOver18\":\"****\",\"totalPrice\":\"****\"}]";
        String actual = jsonMask.maskMessage(correctJsonArray);
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Validate that JsonObject without requiered fields not masking")
    void maskMessage_JsonObject_NoMatchingFields_Ok() {

        String actual = jsonMask.maskMessage(correctJsonObjectNoMatchingFields);
        assertNotNull(actual);
        assertEquals(correctJsonObjectNoMatchingFields, actual);
    }

    @Test
    @DisplayName("Validate that Json Object supported")
    void isSupport_JsonFormatObject_True() {

        assertTrue(jsonMask.isSupport(correctJsonObject));
    }

    @Test
    @DisplayName("Validate that Json Array supported")
    void isSupport_JsonFormatArray_True() {

        assertTrue(jsonMask.isSupport(correctJsonArray));
    }

    @Test
    @DisplayName("Validate that toString object isn't supported")
    void isSupport_StringFormat_False() {

        final String toStringMessage = "[id=123, email=test_mail@i.ua, password=test#String_0, price=8.00]";
        assertFalse(jsonMask.isSupport(toStringMessage));
    }
}
