package com.sokima.lib.corelogging.service;

@FunctionalInterface
public interface Maskable {

    String maskMessage(String message);
}
