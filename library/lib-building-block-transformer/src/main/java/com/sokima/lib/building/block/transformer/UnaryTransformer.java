package com.sokima.lib.core.transformer;

/**
 * Represents one-arity of the {@link Transformer}.
 * Could be useful for Envelope to Envelope transformations.
 */
@FunctionalInterface
public interface UnaryTransformer<T> extends Transformer<T, T> {
    T transform(final T input);
}
