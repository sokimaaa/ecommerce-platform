package com.sokima.lib.corelogging.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sokima.lib.corelogging.service.Masked;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ToStringMaskTest {

    private static final List<String> fields = List.of("email", "password", "phone", "profileId", "totalPrice", "isOver18");

    private static final String givenStringMessage = String.format("TestUser: %s",
            new TestRecord(123L, "test_mail@i.ua", "test#String_0", BigDecimal.valueOf(8.0), true));

    private static final String JsonObject = "{\"id\":123,\"email\":\"test_mail@i.ua\",\"password\":\"test#String_0\",\"isOver18\":true,\"totalPrice\":8.00}";

    private static Masked toStringMask;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {

        toStringMask = new ToStringMask(fields);

    }

    @Test
    @DisplayName("Validate that reqiered fields in toString format are masking")
    void maskMessage_Ok() {

        String actual = toStringMask.maskMessage(givenStringMessage);
        String expected = "TestUser: TestRecord[id=123, email=****, password=****, totalPrice=****, isOver18=****]";
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Validate that toString Object supported")
    void isSupport_ToStringFormat_True() {
        //given

        //when

        //then
    }

    @Test
    @DisplayName("Validate that JsonFormat isn't supported")
    void isSupport_JsonFormat_False() {
        //given

        //when

        //then
    }
}
