package com.sokima.infrastructure.microservice.eoms.adapter.driven.persistent;

import com.sokima.domain.persistent.item.adapter.FindBatchItemPersistentAdapter;
import com.sokima.domain.persistent.item.adapter.InsertBatchItemPersistentAdapter;
import com.sokima.lib.onion.architecture.annotation.DrivenAdapter;

@DrivenAdapter
public class ItemBatchPersistentAdapter implements FindBatchItemPersistentAdapter, InsertBatchItemPersistentAdapter {
}
