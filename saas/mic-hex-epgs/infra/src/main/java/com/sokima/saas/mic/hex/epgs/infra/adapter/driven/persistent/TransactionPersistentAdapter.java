package com.sokima.saas.mic.hex.epgs.infra.adapter.driven.persistent;

import com.sokima.lib.onion.architecture.annotation.DrivenAdapter;
import com.sokima.saas.mic.hex.epgs.domain.persistent.port.inbound.transaction.InsertTransactionPersistentInPort;
import com.sokima.saas.mic.hex.epgs.domain.persistent.port.inbound.transaction.UpdateTransactionPersistentInPort;

@DrivenAdapter
public class TransactionPersistentAdapter implements InsertTransactionPersistentInPort, UpdateTransactionPersistentInPort {
}
