package com.sokima.infrastructure.microservice.escs.adapter.driven.persistent;

import com.sokima.domain.persistent.cart.adapter.FindCartPersistentAdapter;
import com.sokima.domain.persistent.cart.adapter.InsertCartPersistentAdapter;
import com.sokima.domain.persistent.cart.adapter.UpdateCartPersistentAdapter;
import com.sokima.lib.onion.architecture.annotation.DrivenAdapter;

@DrivenAdapter
public class CartPersistentAdapter implements FindCartPersistentAdapter, InsertCartPersistentAdapter, UpdateCartPersistentAdapter {
}
