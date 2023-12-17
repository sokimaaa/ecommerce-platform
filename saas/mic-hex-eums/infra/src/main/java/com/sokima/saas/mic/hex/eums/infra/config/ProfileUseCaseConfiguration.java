package com.sokima.saas.mic.hex.eums.infra.config;

import com.sokima.lib.hex.architecture.annotation.DomainService;
import com.sokima.lib.hex.architecture.annotation.UseCase;
import com.sokima.saas.mic.hex.eums.domain.persistent.port.inbound.profile.InsertProfilePersistentInPort;
import com.sokima.saas.mic.hex.eums.domain.service.ProfileService;
import com.sokima.saas.mic.hex.eums.domain.service.impl.ProfileServiceImpl;
import com.sokima.saas.mic.hex.eums.usecase.ProfileUseCase;
import com.sokima.saas.mic.hex.eums.usecase.impl.ProfileUseCaseImpl;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfileUseCaseConfiguration {

    @UseCase
    ProfileUseCase profileUseCase(
            final ProfileService profileService,
            final InsertProfilePersistentInPort insertProfilePersistentAdapter

    ) {
        return new ProfileUseCaseImpl();
    }

    @DomainService
    ProfileService profileService(
            final InsertProfilePersistentInPort insertProfilePersistentAdapter
    ) {
        return new ProfileServiceImpl();
    }
}
