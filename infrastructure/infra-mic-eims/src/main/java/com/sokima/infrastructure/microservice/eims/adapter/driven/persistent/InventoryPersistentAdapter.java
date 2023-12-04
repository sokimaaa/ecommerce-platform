package com.sokima.infrastructure.microservice.eims.adapter.driven.persistent;

import com.sokima.domain.persistent.inventory.adapter.FindInventoryPersistentAdapter;
import com.sokima.domain.persistent.inventory.adapter.InsertInventoryPersistentAdapter;
import com.sokima.domain.persistent.inventory.adapter.UpdateInventoryPersistentAdapter;
import com.sokima.lib.onion.architecture.annotation.DrivenAdapter;

@DrivenAdapter
public class InventoryPersistentAdapter implements FindInventoryPersistentAdapter, InsertInventoryPersistentAdapter, UpdateInventoryPersistentAdapter {
}
