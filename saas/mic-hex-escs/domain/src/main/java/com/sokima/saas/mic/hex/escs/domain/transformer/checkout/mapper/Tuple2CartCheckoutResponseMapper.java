package com.sokima.saas.mic.hex.escs.domain.transformer.checkout.mapper;

import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationResponse;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.response.CartCheckoutResponse;
import com.sokima.saas.mic.hex.escs.spec.rest.manage.v1.response.CartCleanerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import reactor.util.function.Tuple2;

import java.util.Optional;

@Mapper
public interface Tuple2CartCheckoutResponseMapper {
    Tuple2CartCheckoutResponseMapper INSTANCE = Mappers.getMapper(Tuple2CartCheckoutResponseMapper.class);

    Long INVALID_CART_ID = -1L;

    @Mapping(target = "cartId", expression = "java(mergeCartId(input.getT1().cartId(), input.getT2().getCartId()))")
    @Mapping(target = "transactionId", source = "t1.transactionId")
    @Mapping(target = "orderId", source = "t1.orderId")
    @Mapping(target = "ok", expression = "java(input.getT1().ok() && input.getT2().getOk())")
    CartCheckoutResponse map(final Tuple2<EnrichedOrderInitiationResponse, CartCleanerResponse> input);

    default Long mergeCartId(
            final Long orderInitRespCartId,
            final Long cartCleanRespCartId
    ) {
        return Optional.ofNullable(orderInitRespCartId)
                .filter(cartCleanRespCartId::equals)
                .orElse(INVALID_CART_ID);
    }
}
