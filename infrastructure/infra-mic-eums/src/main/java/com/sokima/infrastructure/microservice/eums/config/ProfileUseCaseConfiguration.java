package com.sokima.infrastructure.microservice.eums.config;

import com.sokima.application.microservice.eums.usecase.ProfileUseCase;
import com.sokima.application.microservice.eums.usecase.impl.ProfileUseCaseImpl;
import com.sokima.domain.persistent.profile.adapter.InsertProfilePersistentAdapter;
import com.sokima.domain.service.user.ProfileService;
import com.sokima.domain.service.user.impl.ProfileServiceImpl;
import com.sokima.lib.onion.architecture.annotation.DomainService;
import com.sokima.lib.onion.architecture.annotation.UseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfileUseCaseConfiguration {

    @UseCase
    ProfileUseCase profileUseCase(
            final ProfileService profileService,
            final InsertProfilePersistentAdapter insertProfilePersistentAdapter

    ) {
        return new ProfileUseCaseImpl();
    }

    @DomainService
    ProfileService profileService(
            final InsertProfilePersistentAdapter insertProfilePersistentAdapter
    ) {
        return new ProfileServiceImpl();
    }
}
