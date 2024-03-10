package com.sokima.saas.mic.hex.escs.domain.transformer.initiation.mapper;

import com.sokima.lib.ecommerce.proto.domain.model.OrderInitiationRequest;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationPayload;
import org.mapstruct.CollectionMappingStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(collectionMappingStrategy = CollectionMappingStrategy.ADDER_PREFERRED)
public interface EnrichedPayload2OrderInitiationMapper {
    EnrichedPayload2OrderInitiationMapper INSTANCE = Mappers.getMapper(EnrichedPayload2OrderInitiationMapper.class);

    int SINGLE_QUANTITY = 1;

    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "shippingAddress", source = "shippingAddress")
    @Mapping(target = "paymentMethod", source = "paymentMethod")
    @Mapping(target = "productIdQuantity", source = "productIds", qualifiedByName = "setProductIdQuantity")
    OrderInitiationRequest map(final EnrichedOrderInitiationPayload payload);

    @Named("setProductIdQuantity")
    default Map<Long, Integer> setProductIdQuantity(final List<Long> productIds) {
        return productIds.stream().collect(Collectors.toMap(
                productId -> productId,
                productId -> SINGLE_QUANTITY,
                Integer::sum
        ));
    }
}
