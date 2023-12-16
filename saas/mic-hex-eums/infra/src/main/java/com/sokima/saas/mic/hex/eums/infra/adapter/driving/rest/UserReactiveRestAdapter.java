package com.sokima.saas.mic.hex.eums.infra.adapter.driving.rest;

import com.sokima.lib.onion.architecture.annotation.DrivingAdapter;
import com.sokima.saas.mic.hex.eums.spec.rest.auth.v1.api.UserAuthenticationReactiveApi;
import com.sokima.saas.mic.hex.eums.spec.rest.auth.v1.api.UserRegistrationReactiveApi;
import com.sokima.saas.mic.hex.eums.spec.rest.auth.v1.request.UserAuthRequest;
import com.sokima.saas.mic.hex.eums.spec.rest.auth.v1.request.UserRegistrationRequest;
import com.sokima.saas.mic.hex.eums.spec.rest.auth.v1.response.UserAuthResponse;
import com.sokima.saas.mic.hex.eums.spec.rest.auth.v1.response.UserRegistrationResponse;
import com.sokima.saas.mic.hex.eums.spec.rest.modify.v1.api.UserModificationReactiveApi;
import com.sokima.saas.mic.hex.eums.spec.rest.modify.v1.request.PasswordModificationRequest;
import com.sokima.saas.mic.hex.eums.spec.rest.modify.v1.request.UsernameModificationRequest;
import com.sokima.saas.mic.hex.eums.spec.rest.modify.v1.response.PasswordModificationResponse;
import com.sokima.saas.mic.hex.eums.spec.rest.modify.v1.response.UsernameModificationResponse;
import com.sokima.saas.mic.hex.eums.usecase.UserUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@DrivingAdapter
public class UserReactiveRestAdapter implements UserAuthenticationReactiveApi, UserModificationReactiveApi, UserRegistrationReactiveApi {
    private final UserUseCase userUseCase;

    public UserReactiveRestAdapter(final UserUseCase userUseCase) {
        this.userUseCase = userUseCase;
    }

    @Override
    public Mono<ResponseEntity<UserAuthResponse>> authenticate(
            final UserAuthRequest userAuthRequest,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new UserAuthResponse(
                -1L,
                Boolean.FALSE
        );
        return Mono.just(ResponseEntity.ok(body));
    }

    @Override
    public Mono<ResponseEntity<UserRegistrationResponse>> register(
            final UserRegistrationRequest userRegistrationRequest,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new UserRegistrationResponse(
                -1L,
                Boolean.FALSE
        );
        return Mono.just(ResponseEntity.ok(body));
    }

    @Override
    public Mono<ResponseEntity<UsernameModificationResponse>> modify(
            final Long userId,
            final UsernameModificationRequest usernameModificationRequest,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new UsernameModificationResponse(
                -1L,
                Boolean.FALSE
        );
        return Mono.just(ResponseEntity.ok(body));
    }

    @Override
    public Mono<ResponseEntity<PasswordModificationResponse>> modify(
            final Long userId,
            final PasswordModificationRequest passwordModificationRequest,
            final ServerWebExchange serverWebExchange
    ) {
        final var body = new PasswordModificationResponse(
                -1L,
                Boolean.FALSE
        );
        return Mono.just(ResponseEntity.ok(body));
    }
}
