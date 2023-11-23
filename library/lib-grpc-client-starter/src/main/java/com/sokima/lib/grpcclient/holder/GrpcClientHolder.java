package com.sokima.lib.grpcclient.holder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrpcClientHolder {
    private String host;

    private Integer port;

    private Integer connectionTimeout;

    private Integer deadline;

    private Integer idleTimeout;
}
