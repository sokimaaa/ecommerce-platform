package com.sokima.saas.mic.hex.escs.infra.config;

import com.sokima.lib.building.block.sender.RequestMessageSender;
import com.sokima.lib.building.block.transformer.Transformer;
import com.sokima.lib.ecommerce.java.domain.model.Cart;
import com.sokima.lib.ecommerce.proto.domain.model.OrderInitiationRequest;
import com.sokima.lib.ecommerce.proto.domain.model.OrderInitiationResponse;
import com.sokima.lib.hex.architecture.annotation.DomainService;
import com.sokima.lib.hex.architecture.annotation.UseCase;
import com.sokima.saas.mic.hex.escs.domain.payload.clean.CleanCartPayload;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.EnrichedOrderInitiationPayload;
import com.sokima.saas.mic.hex.escs.domain.payload.initiation.OrderInitiationPayload;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.inbound.cart.UpdateCartPersistentInPort;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.outbound.cart.FindCartPersistentOutPort;
import com.sokima.saas.mic.hex.escs.domain.transformer.checkout.OrderInitiationResponse2CartCleanPayloadTransformer;
import com.sokima.saas.mic.hex.escs.domain.transformer.checkout.Tuple2CartCheckoutResponseTransformer;
import com.sokima.saas.mic.hex.escs.domain.transformer.checkout.Tuple2OrderInitiationPayloadTransformer;
import com.sokima.saas.mic.hex.escs.domain.transformer.clean.Tuple2CleanedCartTransformer;
import com.sokima.saas.mic.hex.escs.domain.transformer.clean.Tuple2CleanerResponseTransformer;
import com.sokima.saas.mic.hex.escs.domain.transformer.initiation.EnrichedPayload2OrderInitiationTransformer;
import com.sokima.saas.mic.hex.escs.domain.transformer.initiation.Tuple2EnrichedPayloadTransformer;
import com.sokima.saas.mic.hex.escs.domain.validator.CartRuleValidatorChain;
import com.sokima.saas.mic.hex.escs.domain.validator.CartValidatorChain;
import com.sokima.saas.mic.hex.escs.domain.validator.EmptyCartRuleValidator;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.request.CartCheckoutRequest;
import com.sokima.saas.mic.hex.escs.spec.rest.checkout.v1.response.CartCheckoutResponse;
import com.sokima.saas.mic.hex.escs.spec.rest.manage.v1.response.CartCleanerResponse;
import com.sokima.saas.mic.hex.escs.usecase.checkout.CartCheckoutFlow;
import com.sokima.saas.mic.hex.escs.usecase.clean.CartCleanFlow;
import com.sokima.saas.mic.hex.escs.usecase.initiation.OrderInitiationFlow;
import org.springframework.context.annotation.Configuration;
import reactor.util.function.Tuple2;

import java.util.Set;

@Configuration
public class CartUseCaseConfiguration {

    @Configuration
    static class CheckoutCartFlowConfiguration {

        @UseCase
        CartCheckoutFlow cartCheckoutFlow(
                final OrderInitiationFlow orderInitiationFlow,
                final CartCleanFlow cartCleanFlow,
                final Transformer<Tuple2<Long, CartCheckoutRequest>, OrderInitiationPayload> tuple2OrderInitiationPayload,
                final Transformer<OrderInitiationResponse, CleanCartPayload> orderInitiationResponse2CartCleanPayload,
                final Transformer<Tuple2<OrderInitiationResponse, CartCleanerResponse>, CartCheckoutResponse> tuple2CartCheckoutResponse
        ) {
            return new CartCheckoutFlow(
                    orderInitiationFlow,
                    cartCleanFlow,
                    tuple2OrderInitiationPayload,
                    orderInitiationResponse2CartCleanPayload,
                    tuple2CartCheckoutResponse
            );
        }

        @DomainService
        Transformer<Tuple2<Long, CartCheckoutRequest>, OrderInitiationPayload> tuple2OrderInitiationPayloadTransformer() {
            return new Tuple2OrderInitiationPayloadTransformer();
        }

        @DomainService
        Transformer<OrderInitiationResponse, CleanCartPayload> orderInitiationResponse2CartCleanPayloadTransformer() {
            return new OrderInitiationResponse2CartCleanPayloadTransformer();
        }

        @DomainService
        Transformer<Tuple2<OrderInitiationResponse, CartCleanerResponse>, CartCheckoutResponse> tuple2CartCheckoutResponseTransformer() {
            return new Tuple2CartCheckoutResponseTransformer();
        }
    }

    @Configuration
    static class OrderInitiationFlowConfiguration {

        @UseCase
        OrderInitiationFlow orderInitiationFlow(
                final FindCartPersistentOutPort findCartPersistent,
                final CartValidatorChain cartRuleValidatorChain,
                final Transformer<Tuple2<OrderInitiationPayload, Cart>, EnrichedOrderInitiationPayload> tuple2EnrichedPayload,
                final Transformer<EnrichedOrderInitiationPayload, OrderInitiationRequest> enrichedPayload2OrderInitiation,
                final RequestMessageSender<OrderInitiationRequest, OrderInitiationResponse> orderInitiationSender
        ) {
            return new OrderInitiationFlow(
                    findCartPersistent,
                    cartRuleValidatorChain,
                    tuple2EnrichedPayload,
                    enrichedPayload2OrderInitiation,
                    orderInitiationSender
            );
        }

        @DomainService
        Transformer<Tuple2<OrderInitiationPayload, Cart>, EnrichedOrderInitiationPayload> tuple2EnrichedPayloadTransformer() {
            return new Tuple2EnrichedPayloadTransformer();
        }

        @DomainService
        Transformer<EnrichedOrderInitiationPayload, OrderInitiationRequest> enrichedPayload2OrderInitiationTransformer() {
            return new EnrichedPayload2OrderInitiationTransformer();
        }

        @DomainService
        CartValidatorChain cartValidatorChain(final Set<CartRuleValidatorChain> cartRuleValidatorChain) {
            return new CartValidatorChain(cartRuleValidatorChain);
        }

        @DomainService
        CartRuleValidatorChain emptyCartRuleValidator() {
            return new EmptyCartRuleValidator();
        }
    }

    @Configuration
    static class CleanCartFlowConfiguration {

        @UseCase
        CartCleanFlow cartCleanFlow(
                final FindCartPersistentOutPort findCartPersistent,
                final UpdateCartPersistentInPort updateCartPersistent,
                final Transformer<Tuple2<CleanCartPayload, Cart>, Cart> tuple2CleanedCart,
                final Transformer<Tuple2<CleanCartPayload, Cart>, CartCleanerResponse> tuple2CleanerResponse
        ) {
            return new CartCleanFlow(
                    findCartPersistent,
                    updateCartPersistent,
                    tuple2CleanedCart,
                    tuple2CleanerResponse
            );
        }

        @DomainService
        Transformer<Tuple2<CleanCartPayload, Cart>, Cart> tuple2CleanedCartTransformer() {
            return new Tuple2CleanedCartTransformer();
        }

        @DomainService
        Transformer<Tuple2<CleanCartPayload, Cart>, CartCleanerResponse> tuple2CleanerResponseTransformer() {
            return new Tuple2CleanerResponseTransformer();
        }
    }
}
