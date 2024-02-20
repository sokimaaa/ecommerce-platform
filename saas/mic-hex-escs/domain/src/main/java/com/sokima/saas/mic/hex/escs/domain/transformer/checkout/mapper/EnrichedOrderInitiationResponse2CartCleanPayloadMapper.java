package com.sokima.saas.mic.hex.escs.domain.transformer.checkout.mapper;

import com.sokima.lib.ecommerce.java.domain.model.Item;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Mapper
public interface EnrichedOrderInitiationResponse2CartCleanPayloadMapper {
    EnrichedOrderInitiationResponse2CartCleanPayloadMapper INSTANCE = Mappers.getMapper(EnrichedOrderInitiationResponse2CartCleanPayloadMapper.class);

    @Mapping(target = "productIdsToClean", source = "reservedItems", qualifiedByName = "reservedItems2ProductIdsToClean")
    CleanCartPayload map(final EnrichedOrderInitiationResponse input);

    @Named("reservedItems2ProductIdsToClean")
    default List<Long> reservedItems2ProductIdsToClean(final Set<Item> reservedItems) {
        return reservedItems.stream()
                .flatMap(this::reservedItem2ProductIdsToClean)
                .toList();
    }

    default Stream<Long> reservedItem2ProductIdsToClean(final Item reservedItem) {
        return Collections.nCopies(reservedItem.quantity(), reservedItem.productId()).stream();
    }
}
