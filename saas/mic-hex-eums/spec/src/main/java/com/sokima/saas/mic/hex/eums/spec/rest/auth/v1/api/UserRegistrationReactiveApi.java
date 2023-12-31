package com.sokima.saas.mic.hex.eums.spec.rest.auth.v1.api;

import com.sokima.saas.mic.hex.eums.spec.rest.auth.v1.request.UserRegistrationRequest;
import com.sokima.saas.mic.hex.eums.spec.rest.auth.v1.response.UserRegistrationResponse;
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

@Validated
@Tag(name = "registerUser", description = "the reactive registerUser API")
public interface UserRegistrationReactiveApi {

    /**
     * POST /user-registration : User Registration
     *
     * @param userRegistrationRequest - (required)
     * @param serverWebExchange       - (optional)
     * @return OK (status code 201)
     */
    @Operation(
            operationId = "registerUser",
            summary = "User Registration",
            tags = {"userRegistration", "registerUser", "userRegister"},
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Created",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = UserRegistrationResponse.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Incorrect registration request"
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Already exists"
                    )
            }
    )
    @PostMapping(
            value = "/user-registration",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<UserRegistrationResponse>> register(
            @Parameter(name = "userRegistrationRequest", required = true) @Valid @RequestBody UserRegistrationRequest userRegistrationRequest,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }
}
