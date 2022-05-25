package com.microservice.cqrsmicroservicepattern.application.query;

import java.math.BigDecimal;

public record SearchCouponQuery(
        BigDecimal price
) {
}
