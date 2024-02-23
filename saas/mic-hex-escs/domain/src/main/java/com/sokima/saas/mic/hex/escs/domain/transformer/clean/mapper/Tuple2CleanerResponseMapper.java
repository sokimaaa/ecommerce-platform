package com.sokima.saas.mic.hex.escs.domain.transformer.clean.mapper;

import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;
import com.sokima.saas.mic.hex.escs.domain.transformer.clean.Tuple2CleanedCartTransformer;
import com.sokima.saas.mic.hex.escs.spec.rest.manage.v1.response.CartCleanerResponse;

import java.util.Arrays;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import reactor.util.function.Tuple2;

@Mapper
public interface Tuple2CleanerResponseMapper {

    Tuple2CleanerResponseMapper INSTANCE = Mappers.getMapper(Tuple2CleanerResponseMapper.class);

    @Mapping(target = "cartId", source = "t1.cartId")
    @Mapping(target = "cleanedProductIds", source = "t1.productIdsToClean")
    @Mapping(target = "ok", expression = "java(isOkResponse(input))")
    CartCleanerResponse map(final Tuple2<CleanCartPayload, Cart> input);

    @Named("isOkResponse")
    default Boolean isOkResponse(final Tuple2<CleanCartPayload, Cart> input) {

        final Cart transformed = new Tuple2CleanedCartTransformer().transform(input);
        final List<Long> sortedProductCart = input.getT2().productIds().stream().sorted().toList();
        final List<Long> renewedProductCart = Arrays.asList(transformed.productIds(), input.getT1().productIdsToClean()).stream()
                .flatMap(List::stream).sorted().toList();
        return sortedProductCart.equals(renewedProductCart);
    }
}
