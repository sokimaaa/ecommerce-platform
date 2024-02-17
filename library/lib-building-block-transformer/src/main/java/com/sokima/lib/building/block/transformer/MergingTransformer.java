package com.sokima.lib.building.block.transformer;

import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

public final class MergingTransformer {

    private MergingTransformer() {
        throw new UnsupportedOperationException("Instantiation of util class is forbidden.");
    }

    public static <R, L> Tuple2<R, L> merge(final R right, final L left) {
        return Tuples.of(right, left);
    }
}
