package com.sokima.lib.corelogging.service.impl;

import java.math.BigDecimal;

public record TestRecord(Long id, String email, String password, BigDecimal totalPrice, Boolean isOver18) {

}
