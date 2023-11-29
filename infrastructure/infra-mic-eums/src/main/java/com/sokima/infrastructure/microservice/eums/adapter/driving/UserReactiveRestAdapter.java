package com.sokima.infrastructure.microservice.eums.adapter.driving;

import com.sokima.specification.rest.user.auth.v1.api.UserAuthenticationReactiveApi;
import com.sokima.specification.rest.user.auth.v1.api.UserRegistrationReactiveApi;
import com.sokima.specification.rest.user.modify.v1.api.UserModificationReactiveApi;

public class UserReactiveRestAdapter implements UserAuthenticationReactiveApi, UserModificationReactiveApi, UserRegistrationReactiveApi {
}
