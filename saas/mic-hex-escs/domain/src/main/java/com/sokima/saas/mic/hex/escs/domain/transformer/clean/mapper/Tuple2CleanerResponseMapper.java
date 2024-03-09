package com.sokima.saas.mic.hex.escs.domain.transformer.clean.mapper;

import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;
import com.sokima.saas.mic.hex.escs.spec.rest.manage.v1.response.CartCleanerResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import reactor.util.function.Tuple2;

@Mapper
public interface Tuple2CleanerResponseMapper {

    Tuple2CleanerResponseMapper INSTANCE = Mappers.getMapper(Tuple2CleanerResponseMapper.class);

    @Mapping(target = "cartId", source = "t1.cartId")
    @Mapping(target = "cleanedProductIds", source = "t1.productIdsToClean")
    @Mapping(target = "ok", constant = "false")
    CartCleanerResponse map(final Tuple2<CleanCartPayload, Cart> input);
}
