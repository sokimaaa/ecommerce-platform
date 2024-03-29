package com.sokima.lib.building.block.flow;

import com.sokima.lib.building.block.transformer.MergingTransformer;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

public interface BiFlow<P1, P2, R> extends Flow<Tuple2<P1, P2>, R> {
    default Flux<R> doFlow(final P1 rightPayload, final P2 leftPayload) {
        return doFlow(MergingTransformer.merge(rightPayload, leftPayload));
    }
}
