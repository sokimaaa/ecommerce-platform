package com.sokima.saas.mic.hex.eoms.infra.config;

import com.sokima.lib.hex.architecture.annotation.UseCase;
import com.sokima.saas.mic.hex.eoms.usecase.creation.CreationUseCase;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreationUseCaseConfiguration {

    @UseCase
    CreationUseCase creationUseCase() {
        return new CreationUseCase();
    }
}
