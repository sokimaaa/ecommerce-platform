package com.sokima.saas.mic.hex.eims.infra.config;

import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import com.sokima.saas.mic.hex.eims.domain.persistent.port.inbound.warehouse.InsertWarehousePersistentInPort;
import com.sokima.saas.mic.hex.eims.domain.service.WarehouseService;
import com.sokima.saas.mic.hex.eims.domain.service.impl.WarehouseServiceImpl;
import com.sokima.saas.mic.hex.eims.usecase.WarehouseUseCase;
import com.sokima.saas.mic.hex.eims.usecase.impl.WarehouseUseCaseImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WarehouseUseCaseConfiguration {

    @UseCase
    WarehouseUseCase warehouseUseCase(
            final WarehouseService warehouseService,
            final InsertWarehousePersistentInPort insertWarehousePersistentAdapter
    ) {
        return new WarehouseUseCaseImpl();
    }

    @DomainService
    WarehouseService warehouseService(
            final InsertWarehousePersistentInPort insertWarehousePersistentAdapter
    ) {
        return new WarehouseServiceImpl();
    }
}
