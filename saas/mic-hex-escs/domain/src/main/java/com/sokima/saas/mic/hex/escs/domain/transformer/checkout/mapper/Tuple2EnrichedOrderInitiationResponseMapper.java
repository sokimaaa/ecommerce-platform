package com.sokima.saas.mic.hex.escs.domain.transformer.checkout.mapper;

import com.sokima.lib.ecommerce.java.domain.model.Item;
import com.sokima.lib.ecommerce.java.domain.model.proto.ItemProto;
import com.sokima.lib.ecommerce.proto.domain.model.OrderInitiationResponse;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationResponse;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.OrderInitiationPayload;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import reactor.util.function.Tuple2;

@Mapper
public interface Tuple2EnrichedOrderInitiationResponseMapper {
    Tuple2EnrichedOrderInitiationResponseMapper INSTANCE = Mappers.getMapper(Tuple2EnrichedOrderInitiationResponseMapper.class);

    @Mapping(target = "cartId", source = "t1.cartId")
    @Mapping(target = "transactionId", source = "t2.transactionId")
    @Mapping(target = "orderId", source = "t2.orderId")
    @Mapping(target = "reservedItems", source = "t2.reservedItemsList")
    @Mapping(target = "ok", source = "t2.ok")
    EnrichedOrderInitiationResponse map(final Tuple2<OrderInitiationPayload, OrderInitiationResponse> input);

    default Item itemOf(final com.sokima.lib.ecommerce.proto.domain.model.Item delegate) {
        return new ItemProto(delegate);
    }
}
