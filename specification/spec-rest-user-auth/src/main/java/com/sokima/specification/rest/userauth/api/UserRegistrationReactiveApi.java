package com.sokima.specification.rest.userauth.api;

import com.sokima.specification.rest.userauth.request.UserRegistrationRequest;
import com.sokima.specification.rest.userauth.response.UserRegistrationResponse;
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
     * POST /registerUser : User Registration
     *
     * @param userRegistrationRequest - (required)
     * @param serverWebExchange       - (optional)
     * @return OK (status code 200)
     */
    @Operation(
            operationId = "registerUser",
            summary = "User Registration",
            tags = {"userRegistration", "registerUser", "userRegister"},
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = UserRegistrationResponse.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid registration request or such user already exist"
                    )
            }
    )
    @PostMapping(
            value = "/registerUser",
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
