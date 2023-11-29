package com.sokima.infrastructure.microservice.escs.adapter.driving;

import com.sokima.specification.rest.cart.checkout.v1.api.CartCheckoutReactiveApi;
import com.sokima.specification.rest.cart.explore.v1.api.CartExplorationReactiveApi;
import com.sokima.specification.rest.cart.manage.v1.api.CartCleanerReactiveApi;
import com.sokima.specification.rest.cart.manage.v1.api.CartManagementReactiveApi;

public class CartReactiveRestAdapter implements CartExplorationReactiveApi, CartManagementReactiveApi, CartCheckoutReactiveApi, CartCleanerReactiveApi {
}
