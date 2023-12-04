package com.sokima.infrastructure.microservice.epcs.config;

import com.sokima.application.microservice.epcs.usecase.ProductUseCase;
import com.sokima.application.microservice.epcs.usecase.impl.ProductUseCaseImpl;
import com.sokima.domain.persistent.product.adapter.FindBatchProductPersistentAdapter;
import com.sokima.domain.persistent.product.adapter.FindProductPersistentAdapter;
import com.sokima.domain.persistent.product.adapter.InsertProductPersistentAdapter;
import com.sokima.domain.persistent.product.adapter.UpdateProductPersistentAdapter;
import com.sokima.domain.service.product.ProductService;
import com.sokima.domain.service.product.impl.ProductServiceImpl;
import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductUseCaseConfiguration {

    @UseCase
    ProductUseCase productUseCase(
            final ProductService productService,
            final FindBatchProductPersistentAdapter findBatchProductPersistentAdapter,
            final FindProductPersistentAdapter findProductPersistentAdapter,
            final InsertProductPersistentAdapter insertProductPersistentAdapter,
            final UpdateProductPersistentAdapter updateProductPersistentAdapter
    ) {
        return new ProductUseCaseImpl();
    }

    @DomainService
    ProductService productService(
            final FindBatchProductPersistentAdapter findBatchProductPersistentAdapter,
            final FindProductPersistentAdapter findProductPersistentAdapter,
            final InsertProductPersistentAdapter insertProductPersistentAdapter,
            final UpdateProductPersistentAdapter updateProductPersistentAdapter
    ) {
        return new ProductServiceImpl();
    }
}
