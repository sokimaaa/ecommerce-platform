package com.sokima.lib.building.block.sender;

import com.sokima.lib.hex.architecture.annotation.OutPort;

@OutPort
public interface RequestMessageSender<I, O> extends MessageSender<I, O> {
}
