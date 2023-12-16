package com.sokima.saas.mic.hex.eims.infra.adapter.driven.persistent;

import com.sokima.lib.onion.architecture.annotation.DrivenAdapter;
import com.sokima.saas.mic.hex.eims.domain.persistent.port.inbound.inventory.InsertInventoryPersistentInPort;
import com.sokima.saas.mic.hex.eims.domain.persistent.port.inbound.inventory.UpdateInventoryPersistentInPort;
import com.sokima.saas.mic.hex.eims.domain.persistent.port.outbound.inventory.FindInventoryPersistentOutPort;

@DrivenAdapter
public class InventoryPersistentAdapter implements FindInventoryPersistentOutPort, InsertInventoryPersistentInPort, UpdateInventoryPersistentInPort {
}
