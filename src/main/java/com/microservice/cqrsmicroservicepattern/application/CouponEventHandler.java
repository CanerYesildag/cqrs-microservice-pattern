package com.microservice.cqrsmicroservicepattern.application;

import com.microservice.cqrsmicroservicepattern.domain.Coupon;
import com.microservice.cqrsmicroservicepattern.infrastructure.CouponRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CouponEventHandler {

    private final CouponRepository couponRepository;

    @EventListener
    public void handle(Coupon couponEvent) {
        log.info("[handle] Coupon domain event consumed");
        couponRepository.saveOnReadDB(couponEvent);
        log.info("[handle] Coupon domain couponEvent is saved successfully with couponId: {}, discount:{}, lowerLimit: {}",
                couponEvent.getId(), couponEvent.getDiscount(), couponEvent.getLowerLimit());
    }
}
