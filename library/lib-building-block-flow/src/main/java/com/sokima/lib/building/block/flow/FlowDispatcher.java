package com.sokima.lib.building.block.flow;

import com.sokima.lib.core.flow.exception.DispatchingFlowException;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class FlowDispatcher {
    private final Map<String, Flow<?, ?>> flowMap;

    public FlowDispatcher(final List<Flow<?, ?>> flows) {
        this.flowMap = flows.stream().collect(Collectors.toMap(
                Flow::flow,
                Function.identity(),
                (oldFl, newFl) -> {
                    throw new DispatchingFlowException("Fail to compose FlowDispatcher. Provided two same flows [%s, %s].", oldFl, newFl);
                }
        ));
    }

    public <T, R> Flux<R> dispatch(final T payload) {
        throw new UnsupportedOperationException("not implemented"); // todo: implement dispatching logic
    }
}
