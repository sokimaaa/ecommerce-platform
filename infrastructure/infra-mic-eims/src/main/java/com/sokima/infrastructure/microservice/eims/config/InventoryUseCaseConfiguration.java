package com.sokima.infrastructure.microservice.eims.config;

import com.sokima.application.microservice.eims.usecase.InventoryUseCase;
import com.sokima.application.microservice.eims.usecase.impl.InventoryUseCaseImpl;
import com.sokima.domain.persistent.inventory.adapter.FindInventoryPersistentAdapter;
import com.sokima.domain.persistent.inventory.adapter.InsertInventoryPersistentAdapter;
import com.sokima.domain.persistent.inventory.adapter.UpdateInventoryPersistentAdapter;
import com.sokima.domain.service.inventory.InventoryService;
import com.sokima.domain.service.inventory.impl.InventoryServiceImpl;
import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryUseCaseConfiguration {

    @UseCase
    InventoryUseCase inventoryUseCase(
            final InventoryService inventoryService,
            final FindInventoryPersistentAdapter findInventoryPersistentAdapter,
            final InsertInventoryPersistentAdapter insertInventoryPersistentAdapter,
            final UpdateInventoryPersistentAdapter updateInventoryPersistentAdapter
    ) {
        return new InventoryUseCaseImpl();
    }

    @DomainService
    InventoryService inventoryService(
            final FindInventoryPersistentAdapter findInventoryPersistentAdapter,
            final InsertInventoryPersistentAdapter insertInventoryPersistentAdapter,
            final UpdateInventoryPersistentAdapter updateInventoryPersistentAdapter
    ) {
        return new InventoryServiceImpl();
    }
}
