package com.sokima.saas.mic.hex.eoms.infra.adapter.driven.persistent;

import com.sokima.lib.hex.architecture.annotation.DrivenAdapter;
import com.sokima.saas.mic.hex.eoms.domain.persistent.port.inbound.order.UpdateBatchOrderPersistentInPort;
import com.sokima.saas.mic.hex.eoms.domain.persistent.port.outbound.order.FindBatchOrderPersistentOutPort;

@DrivenAdapter
public class OrderBatchPersistentAdapter implements FindBatchOrderPersistentOutPort, UpdateBatchOrderPersistentInPort {
}
