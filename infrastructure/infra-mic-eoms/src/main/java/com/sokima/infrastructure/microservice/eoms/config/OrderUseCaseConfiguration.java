package com.sokima.infrastructure.microservice.eoms.config;

import com.sokima.application.microservice.eoms.usecase.OrderUseCase;
import com.sokima.application.microservice.eoms.usecase.impl.OrderUseCaseImpl;
import com.sokima.domain.persistent.order.adapter.FindOrderPersistentAdapter;
import com.sokima.domain.persistent.order.adapter.InsertOrderPersistentAdapter;
import com.sokima.domain.persistent.order.adapter.UpdateOrderPersistentAdapter;
import com.sokima.domain.service.order.OrderService;
import com.sokima.domain.service.order.impl.OrderServiceImpl;
import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderUseCaseConfiguration {

    @UseCase
    OrderUseCase orderUseCase(
            final OrderService orderService,
            final FindOrderPersistentAdapter findOrderPersistentAdapter,
            final InsertOrderPersistentAdapter insertOrderPersistentAdapter,
            final UpdateOrderPersistentAdapter updateOrderPersistentAdapter
    ) {
        return new OrderUseCaseImpl();
    }

    @DomainService
    OrderService orderService(
            final FindOrderPersistentAdapter findOrderPersistentAdapter,
            final InsertOrderPersistentAdapter insertOrderPersistentAdapter,
            final UpdateOrderPersistentAdapter updateOrderPersistentAdapter
    ) {
        return new OrderServiceImpl();
    }
}
