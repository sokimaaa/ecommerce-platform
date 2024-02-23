package com.sokima.saas.mic.hex.escs.domain.transformer.clean.mapper;

import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.ecommerce.java.domain.model.record.CartRecord;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import reactor.util.function.Tuple2;

@Mapper
public interface Tuple2CleanedCartMapper {

    Tuple2CleanedCartMapper INSTANCE = Mappers.getMapper(Tuple2CleanedCartMapper.class);

    @Mapping(target = "cartId", source = "t1.cartId")
    @Mapping(target = "userId", expression = "java(input.getT2().cartId())")
    @Mapping(target = "updatedAt", expression = "java(Instant.now())")
    @Mapping(target = "productIds", expression = "java(productIdsToClean2ProductIdsToStay(input.getT1().productIdsToClean(), input.getT2().productIds()))")
    CartRecord map(final Tuple2<CleanCartPayload, Cart> input);

    @Named("productIdsToClean2ProductIdsToStay")
    default List<Long> productIdsToClean2ProductIdsToStay(final List<Long> productIdsToClean, final List<Long> productIds) {

        List<Long> copyOfProductIdsToClean = new ArrayList<>();
        copyOfProductIdsToClean.addAll(productIdsToClean);
        return productIds.stream()
                .filter(num -> {
                    if (copyOfProductIdsToClean.contains(num)) {
                        copyOfProductIdsToClean.remove(num);
                        return false;
                    } else {
                        return true;
                    }
                }).toList();
    }
}
