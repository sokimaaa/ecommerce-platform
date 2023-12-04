package com.sokima.infrastructure.microservice.eums.config;

import com.sokima.application.microservice.eums.usecase.UserUseCase;
import com.sokima.application.microservice.eums.usecase.impl.UserUseCaseImpl;
import com.sokima.domain.persistent.user.adapter.FindUserPersistentAdapter;
import com.sokima.domain.persistent.user.adapter.InsertUserPersistentAdapter;
import com.sokima.domain.persistent.user.adapter.UpdateUserPersistentAdapter;
import com.sokima.domain.service.user.UserService;
import com.sokima.domain.service.user.impl.UserServiceImpl;
import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUseCaseConfiguration {

    @UseCase
    UserUseCase userUseCase(
            final UserService userService,
            final FindUserPersistentAdapter findUserPersistentAdapter,
            final InsertUserPersistentAdapter insertUserPersistentAdapter,
            final UpdateUserPersistentAdapter updateUserPersistentAdapter
    ) {
        return new UserUseCaseImpl();
    }

    @DomainService
    UserService userService(
            final FindUserPersistentAdapter findUserPersistentAdapter,
            final InsertUserPersistentAdapter insertUserPersistentAdapter,
            final UpdateUserPersistentAdapter updateUserPersistentAdapter
    ) {
        return new UserServiceImpl();
    }
}
