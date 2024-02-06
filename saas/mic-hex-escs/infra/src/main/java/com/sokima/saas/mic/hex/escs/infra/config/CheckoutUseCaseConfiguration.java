package com.sokima.saas.mic.hex.escs.infra.config;

import com.sokima.lib.hex.architecture.annotation.DomainService;
import com.sokima.lib.hex.architecture.annotation.UseCase;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.outbound.cart.FindCartPersistentOutPort;
import com.sokima.saas.mic.hex.escs.domain.service.CheckoutInitiationService;
import com.sokima.saas.mic.hex.escs.domain.validator.CartRuleValidatorChain;
import com.sokima.saas.mic.hex.escs.domain.validator.CartValidatorChain;
import com.sokima.saas.mic.hex.escs.domain.validator.EmptyCartRuleValidator;
import com.sokima.saas.mic.hex.escs.usecase.checkout.CheckoutUseCase;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class CheckoutUseCaseConfiguration {

    @UseCase
    CheckoutUseCase checkoutUseCase(
            final FindCartPersistentOutPort findCartPersistentOutPort,
            final CheckoutInitiationService checkoutInitiationService,
            final CartValidatorChain cartValidatorChain
    ) {
        return new CheckoutUseCase(
                findCartPersistentOutPort,
                checkoutInitiationService,
                cartValidatorChain
        );
    }

    @DomainService
    CartValidatorChain cartValidatorChain(
            final Set<CartRuleValidatorChain> cartRuleValidatorChain
    ) {
        return new CartValidatorChain(cartRuleValidatorChain);
    }

    @DomainService
    CartRuleValidatorChain cartRuleValidatorChain() {
        return new EmptyCartRuleValidator();
    }
}
