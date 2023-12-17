package com.sokima.saas.mic.hex.epcs.infra.adapter.driven.persistent;

import com.sokima.lib.hex.architecture.annotation.DrivenAdapter;
import com.sokima.saas.mic.hex.epcs.domain.persistent.port.inbound.product.InsertProductPersistentInPort;
import com.sokima.saas.mic.hex.epcs.domain.persistent.port.inbound.product.UpdateProductPersistentInPort;
import com.sokima.saas.mic.hex.epcs.domain.persistent.port.outbound.product.FindProductPersistentOutPort;

@DrivenAdapter
public class ProductPersistentAdapter implements FindProductPersistentOutPort, InsertProductPersistentInPort, UpdateProductPersistentInPort {
}
