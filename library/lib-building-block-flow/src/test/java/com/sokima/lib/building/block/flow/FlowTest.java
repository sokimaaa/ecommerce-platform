package com.sokima.lib.building.block.flow;

import com.sokima.lib.building.block.flow.util.DummyFlow;
import com.sokima.lib.core.flow.exception.WrongFlowNameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class FlowTest {
    @Spy
    DummyFlow dummyFlow;

    @Test
    void checkFlowNaming_SingleWordFlow_True() {
        Mockito.doReturn("flow").when(dummyFlow).flow();
        assertDoesNotThrow(() -> dummyFlow.checkFlowNaming(), "Shouldn't be thrown for single word without numbers or specific symbols.");
    }

    @NullSource
    @EmptySource
    @ParameterizedTest
    void checkFlowNaming_EmptyWordFlow_False(final String flow) {
        Mockito.doReturn(flow).when(dummyFlow).flow();
        assertThrows(WrongFlowNameException.class, () -> dummyFlow.checkFlowNaming(), "Should be thrown for empty or null flow name.");
    }

    @ValueSource(strings = {"flow-", "-flow", "flow1", "123456"})
    @ParameterizedTest
    void checkFlowNaming_SingleWordFlow_False(final String flow) {
        Mockito.doReturn(flow).when(dummyFlow).flow();
        assertThrows(WrongFlowNameException.class, () -> dummyFlow.checkFlowNaming(), "Should be thrown for leading, preceding hyphen or numbers in flow name.");
    }

    @ValueSource(strings = {"dummy-flow", "dummy-dummy-flow", "dummy-dummy-dummy-flow"})
    @ParameterizedTest
    void checkFlowNaming_FewWordsFlow_True(final String flow) {
        Mockito.doReturn(flow).when(dummyFlow).flow();
        assertDoesNotThrow(() -> dummyFlow.checkFlowNaming(), "Shouldn't be thrown for two or more words separated by hyphen without numbers or other specific symbols.");
    }

    @ValueSource(strings = {"dummy-flow-", "-dummy-flow", "dummy--dummy-flow", "dummy1-flow"})
    @ParameterizedTest
    void checkFlowNaming_FewWordsFlow_False(final String flow) {
        Mockito.doReturn(flow).when(dummyFlow).flow();
        assertThrows(WrongFlowNameException.class, () -> dummyFlow.checkFlowNaming(), "Should be thrown for leading, preceding hyphen or numbers in flow name.");
    }

    @ValueSource(strings = {"dummy/flow", "dummy|flow", "dummy\\flow", "dummy_flow", "dummy:flow", "dummy,flow", "dummy.flow"})
    @ParameterizedTest
    void checkFlowNaming_WrongDelimiterSymbols_False(final String flow) {
        Mockito.doReturn(flow).when(dummyFlow).flow();
        assertThrows(WrongFlowNameException.class, () -> dummyFlow.checkFlowNaming(), "Should be thrown for leading, preceding hyphen or numbers in flow name.");
    }
}