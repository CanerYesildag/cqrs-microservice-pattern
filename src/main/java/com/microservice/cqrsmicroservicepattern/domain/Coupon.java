package com.microservice.cqrsmicroservicepattern.domain;

import com.microservice.cqrsmicroservicepattern.application.command.CreateCouponCommand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Random;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coupon {

    private Long id;
    private BigDecimal discount;
    private BigDecimal lowerLimit;

    public Coupon buildFrom(CreateCouponCommand command) {
        return new Coupon(
                new Random().nextLong(),
                command.discount(),
                command.lowerLimit()
        );
    }
}
