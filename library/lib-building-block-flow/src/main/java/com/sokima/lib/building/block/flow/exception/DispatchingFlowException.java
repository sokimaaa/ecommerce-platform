package com.sokima.lib.building.block.flow.exception;

public class DispatchingFlowException extends RuntimeException {
    public DispatchingFlowException(final String message, final Object... objects) {
        super(String.format(message, objects));
    }
}
