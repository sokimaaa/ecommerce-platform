package com.sokima.saas.mic.hex.eoms.infra.config;

import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import com.sokima.saas.mic.hex.eoms.domain.persistent.port.inbound.item.InsertBatchItemPersistentInPort;
import com.sokima.saas.mic.hex.eoms.domain.persistent.port.outbound.item.FindBatchItemPersistentOutPort;
import com.sokima.saas.mic.hex.eoms.domain.service.ItemService;
import com.sokima.saas.mic.hex.eoms.domain.service.impl.ItemServiceImpl;
import com.sokima.saas.mic.hex.eoms.usecase.ItemUseCase;
import com.sokima.saas.mic.hex.eoms.usecase.impl.ItemUseCaseImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ItemUseCaseConfiguration {

    @UseCase
    ItemUseCase itemUseCase(
            final ItemService itemService,
            final FindBatchItemPersistentOutPort findBatchItemPersistentAdapter,
            final InsertBatchItemPersistentInPort insertBatchItemPersistentAdapter
    ) {
        return new ItemUseCaseImpl();
    }

    @DomainService
    ItemService itemService(
            final FindBatchItemPersistentOutPort findBatchItemPersistentAdapter,
            final InsertBatchItemPersistentInPort insertBatchItemPersistentAdapter
    ) {
        return new ItemServiceImpl();
    }
}
