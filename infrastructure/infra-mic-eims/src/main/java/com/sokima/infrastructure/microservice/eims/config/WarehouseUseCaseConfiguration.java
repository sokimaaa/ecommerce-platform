package com.sokima.infrastructure.microservice.eims.config;

import com.sokima.application.microservice.eims.usecase.WarehouseUseCase;
import com.sokima.application.microservice.eims.usecase.impl.WarehouseUseCaseImpl;
import com.sokima.domain.persistent.warehouse.adapter.InsertWarehousePersistentAdapter;
import com.sokima.domain.service.inventory.WarehouseService;
import com.sokima.domain.service.inventory.impl.WarehouseServiceImpl;
import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WarehouseUseCaseConfiguration {

    @UseCase
    WarehouseUseCase warehouseUseCase(
            final WarehouseService warehouseService,
            final InsertWarehousePersistentAdapter insertWarehousePersistentAdapter
    ) {
        return new WarehouseUseCaseImpl();
    }

    @DomainService
    WarehouseService warehouseService(
            final InsertWarehousePersistentAdapter insertWarehousePersistentAdapter
    ) {
        return new WarehouseServiceImpl();
    }
}
