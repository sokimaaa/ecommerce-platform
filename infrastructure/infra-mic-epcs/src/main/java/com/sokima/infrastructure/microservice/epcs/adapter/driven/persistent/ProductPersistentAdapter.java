package com.sokima.infrastructure.microservice.epcs.adapter.driven.persistent;

import com.sokima.domain.persistent.product.adapter.FindProductPersistentAdapter;
import com.sokima.domain.persistent.product.adapter.InsertProductPersistentAdapter;
import com.sokima.domain.persistent.product.adapter.UpdateProductPersistentAdapter;
import com.sokima.lib.onion.architecture.annotation.DrivenAdapter;

@DrivenAdapter
public class ProductPersistentAdapter implements FindProductPersistentAdapter, InsertProductPersistentAdapter, UpdateProductPersistentAdapter {
}
