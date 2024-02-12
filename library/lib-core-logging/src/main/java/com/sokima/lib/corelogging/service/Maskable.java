package com.sokima.lib.corelogging.service;

public interface Maskable {

    String maskMessage(String message);

    Object[] maskArguments(final Object[] args);
}
