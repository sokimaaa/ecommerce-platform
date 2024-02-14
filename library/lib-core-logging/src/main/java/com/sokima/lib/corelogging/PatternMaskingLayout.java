package com.sokima.lib.corelogging;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

import com.sokima.lib.corelogging.service.Maskable;
import com.sokima.lib.corelogging.service.MaskedFactory;
import com.sokima.lib.corelogging.service.MaskedStrategyContainer;
import com.sokima.lib.corelogging.service.SupportMasking;
import com.sokima.lib.corelogging.service.impl.ToStringMask;
import com.sokima.lib.corelogging.service.util.MaskingLoggingEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Stream;

public final class PatternMaskingLayout extends PatternLayout {

    private static final String DELIMETER = ",";

    private MaskedStrategyContainer strategy;

    public void setFields(String fields) {

        final List<String> maskedFields = Stream.of(fields.split(DELIMETER)).map(String::trim).toList();

        ServiceLoader<MaskedFactory> factoryLoader = ServiceLoader.load(MaskedFactory.class);
        List<SupportMasking> factoryList = new ArrayList<>();
        for (MaskedFactory factory : factoryLoader) {
            factoryList.add(factory.create(maskedFields));
        }

        final Maskable toStringMask = new ToStringMask(maskedFields);
        strategy = new MaskedStrategyContainer(factoryList, toStringMask);
    }

    @Override
    public String doLayout(ILoggingEvent event) {

        final String messageBody = Arrays.toString(event.getArgumentArray());
        final Object[] maskedArguments = strategy.getMask(messageBody).maskArguments(event.getArgumentArray());
        return super.doLayout(new MaskingLoggingEvent(event, maskedArguments));
    }
}
