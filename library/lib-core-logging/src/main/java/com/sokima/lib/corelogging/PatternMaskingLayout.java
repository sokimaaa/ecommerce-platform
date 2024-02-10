package com.sokima.lib.corelogging;

import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;

import com.sokima.lib.corelogging.service.Masked;
import com.sokima.lib.corelogging.service.MaskedFactory;
import com.sokima.lib.corelogging.service.MaskedStrategy;
import com.sokima.lib.corelogging.service.impl.ToStringMask;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;
import java.util.stream.Stream;

public final class PatternMaskingLayout extends PatternLayout {

    private static final String DELIMETER = ",";

    private MaskedStrategy strategy;

    public void setFields(String fields) {

        final List<String> maskedFields = Stream.of(fields.split(DELIMETER)).map(String::trim).toList();

        ServiceLoader<MaskedFactory> factoryLoader = ServiceLoader.load(MaskedFactory.class);
        List<Masked> factoryList = new ArrayList<>();
        for (MaskedFactory factory : factoryLoader) {
            factoryList.add(factory.create(maskedFields));
        }

        final Masked toStringMask = new ToStringMask(maskedFields);
        strategy = new MaskedStrategy(factoryList, toStringMask);
    }

    @Override
    public String doLayout(ILoggingEvent event) {

        final String messageBody = event.getArgumentArray()[0].toString();
        return strategy.getMask(messageBody).maskMessage(super.doLayout(event));
    }
}
