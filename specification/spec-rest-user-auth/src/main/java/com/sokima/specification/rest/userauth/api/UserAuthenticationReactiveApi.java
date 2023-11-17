package com.sokima.specification.rest.userauth.api;

import com.sokima.specification.rest.userauth.request.UserAuthRequest;
import com.sokima.specification.rest.userauth.response.UserAuthResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Validated
@Tag(name = "authUser", description = "the reactive userAuth API")
public interface UserAuthenticationReactiveApi {

    /**
     * POST /authUser : User Authentication
     *
     * @param userAuthRequest   - (required)
     * @param serverWebExchange - (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "authenticateUser",
            summary = "User Authentication",
            tags = {"userAuth", "authUser"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = UserAuthResponse.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid authentication request"
                    )
            }
    )
    @PostMapping(
            value = "/authUser",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<UserAuthResponse>> authenticate(
            @Parameter(name = "userAuthRequest", required = true) @Valid @RequestBody UserAuthRequest userAuthRequest,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }
}
