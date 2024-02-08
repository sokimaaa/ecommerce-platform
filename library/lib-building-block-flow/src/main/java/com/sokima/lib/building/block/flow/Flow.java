package com.sokima.lib.building.block.flow;

import com.sokima.lib.building.block.flow.exception.WrongFlowNameException;
import com.sokima.lib.hex.architecture.annotation.UseCase;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * Represents the entire flow from getting inbound payload to return outbound payload.
 * Inside flow does necessary processing, type transformation, and communication with external components.
 * In context of hexagonal architecture flow is the usecase.
 *
 * @param <P> the payload for flow processing.
 * @param <R> the return type after flow processing is done.
 */
@UseCase
public interface Flow<P, R> {
    String FLOW_MATCHING_REGEX = "^([a-z]+-?)*[a-z]+$"; // todo: fix regex

    /**
     * Does logic for the flow.
     */
    Flux<R> doFlow(final P payload);

    /**
     * Helps to identify flow.
     */
    String flow();

    @PostConstruct
    default void checkFlowNaming() {
        if (Objects.isNull(flow()) || !flow().matches(FLOW_MATCHING_REGEX)) {
            throw new WrongFlowNameException("Flow name should match regex: " + FLOW_MATCHING_REGEX);
        }
    }
}
