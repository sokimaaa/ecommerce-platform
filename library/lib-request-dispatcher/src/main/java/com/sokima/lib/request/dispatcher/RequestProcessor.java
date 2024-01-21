package com.sokima.lib.request.dispatcher;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RequestProcessor<I, O> {
    Flux<O> process(Flux<I> input);

    boolean isSupport(Flux<I> input);

    boolean isSupport(Mono<I> input);


}
