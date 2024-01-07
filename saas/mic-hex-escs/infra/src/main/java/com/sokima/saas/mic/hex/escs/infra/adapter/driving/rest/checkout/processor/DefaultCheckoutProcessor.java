package com.sokima.saas.mic.hex.escs.infra.adapter.driving.rest.checkout.processor;

import com.sokima.saas.mic.hex.escs.infra.adapter.driving.rest.checkout.CheckoutProcessor;
import com.sokima.saas.mic.hex.escs.infra.adapter.driving.rest.checkout.mapper.CheckoutResponseMapper;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.request.CartCheckoutRequest;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.response.CartCheckoutResponse;
import com.sokima.saas.mic.hex.escs.usecase.checkout.CheckoutUseCase;
import com.sokima.saas.mic.hex.escs.usecase.clean.CleanUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@ConditionalOnMissingBean(CheckoutProcessor.class)
public class DefaultCheckoutProcessor implements CheckoutProcessor {

    private static final Logger log = LoggerFactory.getLogger(DefaultCheckoutProcessor.class);

    private final CheckoutUseCase checkoutUseCase;

    private final CleanUseCase cleanUseCase;

    public DefaultCheckoutProcessor(final CheckoutUseCase checkoutUseCase, final CleanUseCase cleanUseCase) {
        this.checkoutUseCase = checkoutUseCase;
        this.cleanUseCase = cleanUseCase;
    }

    @Override
    public Mono<CartCheckoutResponse> process(
            final Long cartId,
            final CartCheckoutRequest cartCheckoutRequest
    ) {
        log.info("Start processing cart checkout request...");
        return checkoutUseCase.checkout(cartId, cartCheckoutRequest.getShippingAddress(), cartCheckoutRequest.getPaymentMethod())
                .doOnNext(x -> log.debug("Checkout was performed."))
                .map(CheckoutResponseMapper::composeCheckoutResponse)
                .flatMap(x -> cleanUseCase.clean(x.getCartId())
                        .doOnNext(isCleaned -> log.debug("Clean was performed."))
                        .map(isCleaned -> CheckoutResponseMapper.composeCheckoutResponse(x, isCleaned))
                )
                .doOnNext(x -> log.info("Processing cart checkout request finished."))
                .log();
    }
}
