package com.sokima.saas.mic.hex.escs.infra.adapter.driven.persistent;

import com.sokima.lib.hex.architecture.annotation.DrivenAdapter;
import com.sokima.lib.hex.architecture.annotation.DrivingAdapter;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.inbound.cart.InsertCartPersistentInPort;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.inbound.cart.UpdateCartPersistentInPort;
import com.sokima.saas.mic.hex.escs.domain.persistent.port.outbound.cart.FindCartPersistentOutPort;

@DrivenAdapter
@DrivingAdapter
public class CartPersistentAdapter implements FindCartPersistentOutPort, InsertCartPersistentInPort, UpdateCartPersistentInPort {
}
