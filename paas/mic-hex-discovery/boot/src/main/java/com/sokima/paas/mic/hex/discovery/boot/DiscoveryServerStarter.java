package com.sokima.paas.mic.hex.discovery.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiscoveryServerStarter {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServerStarter.class, args);
    }
}
