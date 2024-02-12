package com.sokima.lib.corelogging.service.util;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.classic.spi.IThrowableProxy;
import ch.qos.logback.classic.spi.LoggerContextVO;

import java.util.List;
import java.util.Map;

import org.slf4j.Marker;
import org.slf4j.event.KeyValuePair;
import org.slf4j.helpers.MessageFormatter;

public class MaskingLoggingEvent implements ILoggingEvent {

    private ILoggingEvent delegat;

    private String message;

    private Object[] argumentArray;

    private String formattedMessage;

    public MaskingLoggingEvent(ILoggingEvent event, Object[] args) {

        this.delegat = event;
        this.message = event.getMessage();
        this.argumentArray = args;
    }

    @Override
    public String getFormattedMessage() {

        if (formattedMessage != null) {
            return formattedMessage;
        }
        if (argumentArray != null) {
            formattedMessage = MessageFormatter.arrayFormat(message, argumentArray).getMessage();
        } else {
            formattedMessage = message;
        }

        return formattedMessage;
    }

    @Override
    public Object[] getArgumentArray() {

        return argumentArray;
    }

    @Override
    public String getThreadName() {

        return delegat.getThreadName();
    }

    @Override
    public Level getLevel() {

        return delegat.getLevel();
    }

    @Override
    public String getMessage() {

        return message;
    }

    @Override
    public String getLoggerName() {

        return delegat.getLoggerName();
    }

    @Override
    public LoggerContextVO getLoggerContextVO() {

        return delegat.getLoggerContextVO();
    }

    @Override
    public IThrowableProxy getThrowableProxy() {

        return delegat.getThrowableProxy();
    }

    @Override
    public StackTraceElement[] getCallerData() {

        return delegat.getCallerData();
    }

    @Override
    public boolean hasCallerData() {

        return delegat.hasCallerData();
    }

    @Override
    public List<Marker> getMarkerList() {

        return delegat.getMarkerList();
    }

    @Override
    public Map<String, String> getMDCPropertyMap() {

        return delegat.getMDCPropertyMap();
    }

    @Override
    public List<KeyValuePair> getKeyValuePairs() {

        return delegat.getKeyValuePairs();
    }

    @Override
    public long getTimeStamp() {

        return delegat.getTimeStamp();
    }

    @Override
    public void prepareForDeferredProcessing() {

        delegat.prepareForDeferredProcessing();
    }

    @Override
    public Map<String, String> getMdc() {

        return delegat.getMdc();
    }

    @Override
    public int getNanoseconds() {

        return delegat.getNanoseconds();
    }

    @Override
    public long getSequenceNumber() {

        return delegat.getSequenceNumber();
    }
}
