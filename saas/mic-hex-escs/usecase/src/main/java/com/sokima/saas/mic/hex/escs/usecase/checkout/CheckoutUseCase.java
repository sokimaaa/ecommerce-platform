package com.sokima.saas.mic.hex.escs.usecase.checkout;

import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.ecommerce.proto.domain.model.CompletionOrderCreation;
import com.sokima.lib.ecommerce.proto.domain.model.InitiateOrderCreation;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.outbound.cart.FindCartPersistentOutPort;
import com.sokima.saas.mic.hex.escs.domain.service.CheckoutInitiationService;
import com.sokima.saas.mic.hex.escs.domain.validator.CartValidatorChain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public final class CheckoutUseCase /* implements Flow<Object, CompletionOrderCreation> */ {

    private static final Logger log = LoggerFactory.getLogger(CheckoutUseCase.class);

    private final FindCartPersistentOutPort findCartPersistent;

    private final CheckoutInitiationService checkoutInitiationService;

    private final CartValidatorChain cartRuleValidatorChain;

//    private RequestMessageSender<?, ?> messageSender;
//
//    private Transformer<?, ?> transformer;

    private Transformer<Cart, InitiateOrderCreation> transformer;

    public CheckoutUseCase(
            final FindCartPersistentOutPort findCartPersistent,
            final CheckoutInitiationService checkoutInitiationService,
            final CartValidatorChain cartRuleValidatorChain
    ) {
        this.findCartPersistent = findCartPersistent;
        this.checkoutInitiationService = checkoutInitiationService;
        this.cartRuleValidatorChain = cartRuleValidatorChain;
    }

    public Mono<CompletionOrderCreation> checkout(final Long cartId, final String shippingAddress, final String paymentMethod) {
        return findCartPersistent.findSingleCart(cartId)
                .doOnNext(cart -> {
                    log.debug("Found Cart[value={}] to being checkout.", cart);
                    final var isValid = cartRuleValidatorChain.validateCart(cart);
                    // rollback transaction
                })
//                .map(cart -> CheckoutInitiationMapper.composeInitiateOrderCreation(cart.userId(), cart.productIds(), shippingAddress, paymentMethod))
                .map(cart -> transformer.transform(cart))
                .flatMap(checkoutInitiationService::initiateOrderCreation)
                .doOnNext(x -> log.info("Order for Cart[cartId={}] was initiated.", cartId));
    }
}
