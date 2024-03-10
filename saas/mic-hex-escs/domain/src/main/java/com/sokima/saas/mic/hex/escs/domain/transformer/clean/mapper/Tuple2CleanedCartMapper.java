package com.sokima.saas.mic.hex.escs.domain.transformer.clean.mapper;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.ecommerce.java.domain.model.record.CartRecord;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import reactor.util.function.Tuple2;

import java.util.List;

@Mapper
public interface Tuple2CleanedCartMapper {

    Tuple2CleanedCartMapper INSTANCE = Mappers.getMapper(Tuple2CleanedCartMapper.class);

    default Cart map(final Tuple2<CleanCartPayload, Cart> input) {
        return cartOf(input);
    }

    @Mapping(target = "cartId", source = "t1.cartId")
    @Mapping(target = "userId", expression = "java(input.getT2().userId())")
    @Mapping(target = "updatedAt", expression = "java(input.getT2().updatedAt())")
    @Mapping(target = "productIds", expression = "java(productIdsToClean2ProductIdsToStay(input.getT1().productIdsToClean(), input.getT2().productIds()))")
    CartRecord cartOf(final Tuple2<CleanCartPayload, Cart> input);

    default List<Long> productIdsToClean2ProductIdsToStay(final List<Long> productIdsToClean, final List<Long> productIds) {
        final Multiset<Long> productIdsToStay = HashMultiset.create(productIds);
        Multisets.removeOccurrences(productIdsToStay, productIdsToClean);
        return productIdsToStay.stream().toList();
    }
}
