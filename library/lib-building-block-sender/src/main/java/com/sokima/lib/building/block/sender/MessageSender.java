package com.sokima.lib.building.block.sender;

import reactor.core.publisher.Flux;

/**
 * Represents the building block of the flow that responsible for interacting with external components, e.g. other services.
 * Typical implementation of message sender is grpc adapter that communicates to other services.
 * In context of hexagonal architecture message sender is the in/out port depending on its goals.
 *
 * @param <I> the input message to being sent.
 * @param <O> the output message response.
 */
interface MessageSender<I, O> {
    Flux<O> send(final I request);
}
