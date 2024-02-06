package com.sokima.saas.mic.hex.eoms.domain.service.duplication;

import reactor.core.publisher.Mono;

public interface RequestDuplicationService<R> {

    Mono<Boolean> isDuplicated(final R request);

}
