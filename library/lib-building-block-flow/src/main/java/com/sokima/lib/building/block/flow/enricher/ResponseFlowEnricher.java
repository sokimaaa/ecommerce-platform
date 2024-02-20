package com.sokima.lib.building.block.flow.enricher;

import com.sokima.lib.building.block.flow.Flow;
import com.sokima.lib.building.block.transformer.MergingTransformer;
import com.sokima.lib.building.block.transformer.Transformer;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

public final class ResponseFlowEnricher<P, R, E> implements Flow<P, E> {
    private final Flow<P, R> delegate;
    private final Transformer<Tuple2<P, R>, E> enricher;

    public ResponseFlowEnricher(
            final Flow<P, R> delegate,
            final Transformer<Tuple2<P, R>, E> enricher
    ) {
        this.delegate = delegate;
        this.enricher = enricher;
    }

    @Override
    public Flux<E> doFlow(final P payload) {
        return delegate.doFlow(payload)
                .map(resp -> MergingTransformer.merge(payload, resp))
                .map(enricher::transform);
    }

    @Override
    public String flow() {
        return delegate.flow();
    }
}
