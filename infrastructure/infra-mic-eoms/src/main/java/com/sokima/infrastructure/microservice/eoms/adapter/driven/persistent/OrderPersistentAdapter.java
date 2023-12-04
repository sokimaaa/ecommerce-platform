package com.sokima.infrastructure.microservice.eoms.adapter.driven.persistent;

import com.sokima.domain.persistent.order.adapter.FindOrderPersistentAdapter;
import com.sokima.domain.persistent.order.adapter.InsertOrderPersistentAdapter;
import com.sokima.domain.persistent.order.adapter.UpdateOrderPersistentAdapter;
import com.sokima.lib.onion.architecture.annotation.DrivenAdapter;

@DrivenAdapter
public class OrderPersistentAdapter implements FindOrderPersistentAdapter, InsertOrderPersistentAdapter, UpdateOrderPersistentAdapter {
}
