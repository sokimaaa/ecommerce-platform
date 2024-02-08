package com.sokima.lib.building.block.sender;

import com.sokima.lib.hex.architecture.annotation.InPort;

@InPort
public interface ResponseMessageSender<I, O> extends MessageSender<I, O> {
}
