package com.sokima.lib.corelogging.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sokima.lib.corelogging.service.Maskable;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ToStringMaskTest {

    @Test
    @DisplayName("Validate that reqiered fields in toString format are masking")
    void maskMessage_Ok() {

        Maskable toStringMask = new ToStringMask(List.of("email", "password", "phone", "profileId", "totalPrice", "isOver18"));
        String givenStringMessage = String.format("TestUser: %s",
                new TestRecord(123L, "test_mail@i.ua", "test#String_0", BigDecimal.valueOf(8.0), true, "(+000)-00-000-0000"));
        String actual = toStringMask.maskMessage(givenStringMessage);
        String expected = "TestUser: TestRecord[id=123, email=****, password=****, totalPrice=****, isOver18=****, phone=****]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Validate that cople objects fields in toString format are masking")
    void maskMessage_CopleObjects_Ok() {

        Maskable toStringMask = new ToStringMask(List.of("email", "password", "phone", "profileId"));
        String givenStringMessage = String.format("TestUser: %s, %s",
                new TestRecord(123L, "test_mail@i.ua", "test#String_0", BigDecimal.valueOf(8.0), false, null),
                new TestRecord(124L, "test_mail2@i.ua", "test2#String_0", BigDecimal.valueOf(10.5), true, "(+000) 00000 0000"));
        String actual = toStringMask.maskMessage(givenStringMessage);
        String expected = "TestUser: TestRecord[id=123, email=****, password=****, totalPrice=8.0, isOver18=false, phone=****], "
                + "TestRecord[id=124, email=****, password=****, totalPrice=10.5, isOver18=true, phone=****]";
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    @DisplayName("Validate that maskArguments in toString format are masking")
    void maskArguments_Array_Ok(List<String> fields, Object[] arguments, Object[] expected) {

        ToStringMask maskService = new ToStringMask(fields);
        Object[] actual = maskService.maskArguments(arguments);
        assertNotNull(actual);
        assertEquals(String.format("%s", expected), String.format("%s", actual));
    }

    private static Stream<Arguments> argumentsProvider() {

        final TestRecord inputEmptyRecord = new TestRecord(null, null, null, null, null, null);
        final String expectedEnptyRecord = "TestRecord[id=null, email=****, password=****, totalPrice=null, isOver18=null, phone=****]";
        final TestRecord inputRecord = new TestRecord(124L, "test_mail2@i.ua", "test2#String_0", BigDecimal.valueOf(10.53), false,
                "(+000) 00000 0000");
        final String expectedRecord = "TestRecord[id=124, email=test_mail2@i.ua, password=****, totalPrice=****, isOver18=****, phone=(+000) 00000 0000]";
        return Stream.of(
                Arguments.of(List.of("email", "password", "phone", "profileId"), new Object[] {inputEmptyRecord},
                        new Object[] {expectedEnptyRecord}),
                Arguments.of(List.of("email", "password"), new Object[] {""}, new Object[] {""}),
                Arguments.of(List.of("password", "isOver18", "totalPrice"), new Object[] {inputRecord, inputEmptyRecord, inputRecord},
                        new Object[] {expectedRecord, expectedEnptyRecord, expectedRecord}));
    }
}
