package com.sokima.saas.mic.hex.eoms.infra.config;

import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import com.sokima.saas.mic.hex.eoms.domain.persistent.port.inbound.order.InsertOrderPersistentInPort;
import com.sokima.saas.mic.hex.eoms.domain.persistent.port.inbound.order.UpdateBatchOrderPersistentInPort;
import com.sokima.saas.mic.hex.eoms.domain.persistent.port.inbound.order.UpdateOrderPersistentInPort;
import com.sokima.saas.mic.hex.eoms.domain.persistent.port.outbound.order.FindBatchOrderPersistentOutPort;
import com.sokima.saas.mic.hex.eoms.domain.service.OrderService;
import com.sokima.saas.mic.hex.eoms.domain.service.impl.OrderServiceImpl;
import com.sokima.saas.mic.hex.eoms.usecase.OrderUseCase;
import com.sokima.saas.mic.hex.eoms.usecase.impl.OrderUseCaseImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderUseCaseConfiguration {

    @UseCase
    OrderUseCase orderUseCase(
            final OrderService orderService,
            final FindBatchOrderPersistentOutPort findOrderPersistentAdapter,
            final InsertOrderPersistentInPort insertOrderPersistentAdapter,
            final UpdateOrderPersistentInPort updateOrderPersistentAdapter,
            final UpdateBatchOrderPersistentInPort updateOrderBatchPersistentAdapter
    ) {
        return new OrderUseCaseImpl();
    }

    @DomainService
    OrderService orderService(
            final OrderService orderService,
            final FindBatchOrderPersistentOutPort findOrderPersistentAdapter,
            final InsertOrderPersistentInPort insertOrderPersistentAdapter,
            final UpdateOrderPersistentInPort updateOrderPersistentAdapter,
            final UpdateBatchOrderPersistentInPort updateOrderBatchPersistentAdapter
    ) {
        return new OrderServiceImpl();
    }
}
