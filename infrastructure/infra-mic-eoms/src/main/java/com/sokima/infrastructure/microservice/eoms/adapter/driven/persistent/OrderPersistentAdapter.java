package com.sokima.infrastructure.microservice.eoms.adapter.driven;

import com.sokima.domain.persistent.order.adapter.FindOrderPersistentAdapter;
import com.sokima.domain.persistent.order.adapter.InsertOrderPersistentAdapter;
import com.sokima.domain.persistent.order.adapter.UpdateOrderPersistentAdapter;

public class OrderPersistentAdapter implements FindOrderPersistentAdapter, InsertOrderPersistentAdapter, UpdateOrderPersistentAdapter {
}
