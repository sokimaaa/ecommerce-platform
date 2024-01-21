package com.sokima.lib.request.dispatcher;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RequestDispatcher<I, O> {
    Flux<O> dispatch(final Flux<I> input);

    default Flux<O> dispatch(final Mono<I> input) {
        return dispatch(input.flux());
    }

    default Flux<O> dispatch(final I input) {
        return dispatch(Mono.just(input));
    }
}
