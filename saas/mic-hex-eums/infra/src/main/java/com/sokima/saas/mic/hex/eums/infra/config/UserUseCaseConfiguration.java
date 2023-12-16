package com.sokima.saas.mic.hex.eums.infra.config;

import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import com.sokima.saas.mic.hex.eums.domain.persistent.port.inbound.user.InsertUserPersistentInPort;
import com.sokima.saas.mic.hex.eums.domain.persistent.port.inbound.user.UpdateUserPersistentInPort;
import com.sokima.saas.mic.hex.eums.domain.persistent.port.outbound.user.FindUserPersistentOutPort;
import com.sokima.saas.mic.hex.eums.domain.service.UserService;
import com.sokima.saas.mic.hex.eums.domain.service.impl.UserServiceImpl;
import com.sokima.saas.mic.hex.eums.usecase.UserUseCase;
import com.sokima.saas.mic.hex.eums.usecase.impl.UserUseCaseImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserUseCaseConfiguration {

    @UseCase
    UserUseCase userUseCase(
            final UserService userService,
            final FindUserPersistentOutPort findUserPersistentAdapter,
            final InsertUserPersistentInPort insertUserPersistentAdapter,
            final UpdateUserPersistentInPort updateUserPersistentAdapter
    ) {
        return new UserUseCaseImpl();
    }

    @DomainService
    UserService userService(
            final FindUserPersistentOutPort findUserPersistentAdapter,
            final InsertUserPersistentInPort insertUserPersistentAdapter,
            final UpdateUserPersistentInPort updateUserPersistentAdapter
    ) {
        return new UserServiceImpl();
    }
}
