package com.sokima.infrastructure.microservice.epgs.adapter.driven.persistent;

import com.sokima.domain.persistent.transaction.adapter.InsertTransactionPersistentAdapter;
import com.sokima.domain.persistent.transaction.adapter.UpdateTransactionPersistentAdapter;
import com.sokima.lib.onion.architecture.annotation.DrivenAdapter;

@DrivenAdapter
public class TransactionPersistentAdapter implements InsertTransactionPersistentAdapter, UpdateTransactionPersistentAdapter {
}
