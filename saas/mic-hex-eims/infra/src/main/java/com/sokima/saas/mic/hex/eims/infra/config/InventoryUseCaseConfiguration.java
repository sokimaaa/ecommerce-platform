package com.sokima.saas.mic.hex.eims.infra.config;

import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import com.sokima.saas.mic.hex.eims.domain.persistent.port.inbound.inventory.InsertInventoryPersistentInPort;
import com.sokima.saas.mic.hex.eims.domain.persistent.port.inbound.inventory.UpdateInventoryPersistentInPort;
import com.sokima.saas.mic.hex.eims.domain.persistent.port.outbound.inventory.FindInventoryPersistentOutPort;
import com.sokima.saas.mic.hex.eims.domain.service.InventoryService;
import com.sokima.saas.mic.hex.eims.domain.service.impl.InventoryServiceImpl;
import com.sokima.saas.mic.hex.eims.usecase.InventoryUseCase;
import com.sokima.saas.mic.hex.eims.usecase.impl.InventoryUseCaseImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryUseCaseConfiguration {

    @UseCase
    InventoryUseCase inventoryUseCase(
            final InventoryService inventoryService,
            final FindInventoryPersistentOutPort findInventoryPersistentAdapter,
            final InsertInventoryPersistentInPort insertInventoryPersistentAdapter,
            final UpdateInventoryPersistentInPort updateInventoryPersistentAdapter
    ) {
        return new InventoryUseCaseImpl();
    }

    @DomainService
    InventoryService inventoryService(
            final FindInventoryPersistentOutPort findInventoryPersistentAdapter,
            final InsertInventoryPersistentInPort insertInventoryPersistentAdapter,
            final UpdateInventoryPersistentInPort updateInventoryPersistentAdapter
    ) {
        return new InventoryServiceImpl();
    }
}
