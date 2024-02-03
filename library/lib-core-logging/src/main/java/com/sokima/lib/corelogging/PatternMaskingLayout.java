package com.sokima.lib.corelogging;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import com.sokima.lib.corelogging.usecase.MaskUseCase;
import com.sokima.lib.corelogging.usecase.impl.JsonMaskUseCaseImpl;
import com.sokima.lib.corelogging.usecase.impl.ToStringMaskUseCaseImpl;

import java.util.List;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatternMaskingLayout extends PatternLayout {
    private static final String DELIMETER = ",";
    private MaskUseCase jsonMaskUseCase;
    private MaskUseCase toStringMaskUseCase;
    Logger logger = LoggerFactory.getLogger(PatternMaskingLayout.class);

    public void setFields(String fields) {
        List<String> maskedFields =
                Stream.of(fields.split(DELIMETER))
                        .map(String::trim)
                        .toList();
        jsonMaskUseCase = new JsonMaskUseCaseImpl(maskedFields);
        toStringMaskUseCase = new ToStringMaskUseCaseImpl(maskedFields);
    }

    @Override
    public String doLayout(ILoggingEvent event) {
        return maskMessage(super.doLayout(event));
    }

    private String maskMessage(String message) {
        if (message.contains("{\"")) {
            return jsonMaskUseCase.maskMessage(message);
        }
        return toStringMaskUseCase.maskMessage(message);
    }
}
