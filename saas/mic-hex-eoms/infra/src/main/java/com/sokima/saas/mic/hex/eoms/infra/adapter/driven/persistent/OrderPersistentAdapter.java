package com.sokima.saas.mic.hex.eoms.infra.adapter.driven.persistent;

import com.sokima.lib.hex.architecture.annotation.DrivenAdapter;
import com.sokima.saas.mic.hex.eoms.domain.persistent.port.inbound.order.InsertOrderPersistentInPort;
import com.sokima.saas.mic.hex.eoms.domain.persistent.port.inbound.order.UpdateBatchOrderPersistentInPort;
import com.sokima.saas.mic.hex.eoms.domain.persistent.port.outbound.order.FindOrderPersistentOutPort;

@DrivenAdapter
public class OrderPersistentAdapter implements FindOrderPersistentOutPort, InsertOrderPersistentInPort, UpdateBatchOrderPersistentInPort {
}
