package com.sokima.lib.grpcserver.api;

import net.devh.boot.grpc.server.service.GrpcService;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@GrpcService
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface EnvelopeImplementation {
}
