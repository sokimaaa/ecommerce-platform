package com.sokima.saas.mic.hex.escs.domain.transformer.checkout.mapper;

import com.sokima.saas.mic.hex.escs.domain.payload.initiation.OrderInitiationPayload;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.request.CartCheckoutRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import reactor.util.function.Tuple2;

@Mapper
public interface Tuple2OrderInitiationPayloadMapper {
    Tuple2OrderInitiationPayloadMapper INSTANCE = Mappers.getMapper(Tuple2OrderInitiationPayloadMapper.class);

    @Mapping(target = "cartId", source = "t1")
    @Mapping(target = "shippingAddress", source = "t2.shippingAddress")
    @Mapping(target = "paymentMethod", source = "t2.paymentMethod")
    OrderInitiationPayload map(final Tuple2<Long, CartCheckoutRequest> input);
}
