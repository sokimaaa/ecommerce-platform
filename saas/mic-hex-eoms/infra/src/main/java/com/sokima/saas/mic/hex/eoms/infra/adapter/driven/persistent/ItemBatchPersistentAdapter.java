package com.sokima.saas.mic.hex.eoms.infra.adapter.driven.persistent;

import com.sokima.lib.hex.architecture.annotation.DrivenAdapter;
import com.sokima.saas.mic.hex.eoms.domain.persistent.port.inbound.item.InsertBatchItemPersistentInPort;
import com.sokima.saas.mic.hex.eoms.domain.persistent.port.outbound.item.FindBatchItemPersistentOutPort;

@DrivenAdapter
public class ItemBatchPersistentAdapter implements FindBatchItemPersistentOutPort, InsertBatchItemPersistentInPort {
}
