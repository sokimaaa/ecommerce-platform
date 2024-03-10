package com.sokima.saas.mic.hex.escs.domain.transformer.initiation.mapper;

import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationPayload;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.OrderInitiationPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import reactor.util.function.Tuple2;

@Mapper
public interface Tuple2EnrichedPayloadMapper {
    Tuple2EnrichedPayloadMapper INSTANCE = Mappers.getMapper(Tuple2EnrichedPayloadMapper.class);

    @Mapping(target = "cartId", source = "t1.cartId")
    @Mapping(target = "userId", expression = "java(tuple2.getT2().userId())")
    @Mapping(target = "productIds", expression = "java(tuple2.getT2().productIds())")
    @Mapping(target = "shippingAddress", source = "t1.shippingAddress")
    @Mapping(target = "paymentMethod", source = "t1.paymentMethod")
    EnrichedOrderInitiationPayload map(final Tuple2<OrderInitiationPayload, Cart> tuple2);
}
