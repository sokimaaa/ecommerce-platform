package com.sokima.saas.mic.hex.escs.domain.transformer.checkout;

import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.ecommerce.proto.domain.model.InitiateOrderCreation;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
interface CheckoutInitiationMapper {
    CheckoutInitiationMapper INSTANCE = Mappers.getMapper(CheckoutInitiationMapper.class);

    InitiateOrderCreation transform(final Cart input); // todo: implement mapping
}
