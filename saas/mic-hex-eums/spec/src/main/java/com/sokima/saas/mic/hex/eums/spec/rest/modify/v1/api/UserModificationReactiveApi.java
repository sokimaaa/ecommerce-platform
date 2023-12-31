package com.sokima.saas.mic.hex.eums.spec.rest.modify.v1.api;

import com.sokima.saas.mic.hex.eums.spec.rest.modify.v1.request.PasswordModificationRequest;
import com.sokima.saas.mic.hex.eums.spec.rest.modify.v1.request.UsernameModificationRequest;
import com.sokima.saas.mic.hex.eums.spec.rest.modify.v1.response.PasswordModificationResponse;
import com.sokima.saas.mic.hex.eums.spec.rest.modify.v1.response.UsernameModificationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Validated
@Tag(name = "modifyUser", description = "the reactive modifyUser API")
public interface UserModificationReactiveApi {

    /**
     * PATCH /users/{userId}/username : Username Modification
     *
     * @param userId                      - (required)
     * @param usernameModificationRequest - (required)
     * @param serverWebExchange           - (optional)
     * @return OK (status code 202)
     */
    @Operation(
            operationId = "modifyUserUsername",
            summary = "Modification of User username",
            tags = {"modifyUsername", "modifyUserUsername"},
            responses = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Accepted",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = UsernameModificationResponse.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid modification request or illegal modification"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized"
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden"
                    )
            }
    )
    @PatchMapping(
            value = "/users/{userId}/username",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<UsernameModificationResponse>> modify(
            @Parameter(name = "userId", required = true) @PathVariable("userId") final Long userId,
            @Parameter(name = "usernameModificationRequest", required = true) @Valid @RequestBody UsernameModificationRequest usernameModificationRequest,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }

    /**
     * PATCH /users/{userId}/password : Password Modification
     *
     * @param userId                      - (required)
     * @param passwordModificationRequest - (required)
     * @param serverWebExchange           - (optional)
     * @return OK (status code 202)
     */
    @Operation(
            operationId = "modifyUserPassword",
            summary = "Modification of User password",
            tags = {"modifyPassword", "modifyUserPassword"},
            responses = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Accepted",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            schema = @Schema(implementation = PasswordModificationResponse.class)
                                    )
                            }
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Invalid modification request or illegal modification"
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Unauthorized"
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Forbidden"
                    )
            }
    )
    @PatchMapping(
            value = "/users/{userId}/password",
            produces = "application/json",
            consumes = "application/json"
    )
    default Mono<ResponseEntity<PasswordModificationResponse>> modify(
            @Parameter(name = "userId", required = true) @PathVariable("userId") final Long userId,
            @Parameter(name = "passwordModificationRequest", required = true) @Valid @RequestBody PasswordModificationRequest passwordModificationRequest,
            @Parameter(hidden = true) final ServerWebExchange serverWebExchange
    ) {
        return Mono.empty();
    }
}
