package com.sokima.infrastructure.microservice.eoms.adapter.driven.persistent;

import com.sokima.domain.persistent.order.adapter.FindBatchOrderPersistentAdapter;
import com.sokima.domain.persistent.order.adapter.UpdateBatchOrderPersistentAdapter;
import com.sokima.lib.onion.architecture.annotation.DrivenAdapter;

@DrivenAdapter
public class OrderBatchPersistentAdapter implements FindBatchOrderPersistentAdapter, UpdateBatchOrderPersistentAdapter {
}
