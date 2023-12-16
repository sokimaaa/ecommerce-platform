package com.sokima.saas.mic.hex.epcs.infra.config;

import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import com.sokima.saas.mic.hex.epcs.domain.persistent.port.inbound.product.InsertProductPersistentInPort;
import com.sokima.saas.mic.hex.epcs.domain.persistent.port.inbound.product.UpdateProductPersistentInPort;
import com.sokima.saas.mic.hex.epcs.domain.persistent.port.outbound.product.FindBatchProductPersistentOutPort;
import com.sokima.saas.mic.hex.epcs.domain.persistent.port.outbound.product.FindProductPersistentOutPort;
import com.sokima.saas.mic.hex.epcs.domain.service.ProductService;
import com.sokima.saas.mic.hex.epcs.domain.service.impl.ProductServiceImpl;
import com.sokima.saas.mic.hex.epcs.usecase.ProductUseCase;
import com.sokima.saas.mic.hex.epcs.usecase.impl.ProductUseCaseImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductUseCaseConfiguration {

    @UseCase
    ProductUseCase productUseCase(
            final ProductService productService,
            final FindBatchProductPersistentOutPort findBatchProductPersistentAdapter,
            final FindProductPersistentOutPort findProductPersistentAdapter,
            final InsertProductPersistentInPort insertProductPersistentAdapter,
            final UpdateProductPersistentInPort updateProductPersistentAdapter
    ) {
        return new ProductUseCaseImpl();
    }

    @DomainService
    ProductService productService(
            final FindBatchProductPersistentOutPort findBatchProductPersistentAdapter,
            final FindProductPersistentOutPort findProductPersistentAdapter,
            final InsertProductPersistentInPort insertProductPersistentAdapter,
            final UpdateProductPersistentInPort updateProductPersistentAdapter
    ) {
        return new ProductServiceImpl();
    }
}
