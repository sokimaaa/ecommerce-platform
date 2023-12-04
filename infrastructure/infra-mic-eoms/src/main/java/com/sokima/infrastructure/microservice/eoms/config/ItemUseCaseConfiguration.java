package com.sokima.infrastructure.microservice.eoms.config;

import com.sokima.application.microservice.eoms.usecase.ItemUseCase;
import com.sokima.application.microservice.eoms.usecase.impl.ItemUseCaseImpl;
import com.sokima.domain.persistent.item.adapter.FindBatchItemPersistentAdapter;
import com.sokima.domain.persistent.item.adapter.InsertBatchItemPersistentAdapter;
import com.sokima.domain.service.order.ItemService;
import com.sokima.domain.service.order.impl.ItemServiceImpl;
import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemUseCaseConfiguration {

    @UseCase
    ItemUseCase itemUseCase(
            final ItemService itemService,
            final FindBatchItemPersistentAdapter findBatchItemPersistentAdapter,
            final InsertBatchItemPersistentAdapter insertBatchItemPersistentAdapter
    ) {
        return new ItemUseCaseImpl();
    }

    @DomainService
    ItemService itemService(
            final FindBatchItemPersistentAdapter findBatchItemPersistentAdapter,
            final InsertBatchItemPersistentAdapter insertBatchItemPersistentAdapter
    ) {
        return new ItemServiceImpl();
    }
}
