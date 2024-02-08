package com.sokima.lib.building.block.transformer;

import com.sokima.lib.hex.architecture.annotation.DomainService;

/**
 * Represents the mapper, type converter or just transformer.
 * Main goal is to provide contract for any type transformations.
 * Often implementation of transformer will be mapper from mapstruct.
 * Transformer is the building block of the concrete flow (usecase).
 * In context of hexagonal architecture transformer is the domain service.
 *
 * @param <I> the input type to being transformed.
 * @param <O> the output type that was transformed.
 */
@DomainService
@FunctionalInterface
public interface Transformer<I, O> {
    O transform(final I input);
}
