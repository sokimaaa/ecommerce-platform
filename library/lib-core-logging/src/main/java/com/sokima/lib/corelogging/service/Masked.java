package com.sokima.lib.corelogging.service;

public interface Masked {

    String maskMessage(String message);

    boolean isSupport(String message);

    default String ifSupportThenMask() {
        //not implemented yet
        return null;
    }
}
