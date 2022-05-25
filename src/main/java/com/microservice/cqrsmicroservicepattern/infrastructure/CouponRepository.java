package com.microservice.cqrsmicroservicepattern.infrastructure;

import com.microservice.cqrsmicroservicepattern.domain.Coupon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Random;

@Slf4j
@Repository
public class CouponRepository {

    public Coupon getById(Long id) {
        Coupon coupon = new Coupon(id, BigDecimal.ONE, BigDecimal.TEN);
        log.info("[getById] Coupon is got successfully with couponId: {}", coupon.getId());
        return coupon;
    }

    public Coupon search(BigDecimal price) {
        Coupon coupon = new Coupon(new Random().nextLong(0, 999999), price, BigDecimal.TEN);
        log.info("[search] Coupon is searched successfully with couponId: {}", coupon.getId());
        return coupon;
    }

    public void saveOnWriteDB(Coupon coupon) {
        log.info("[saveOnWriteDB] Coupon is saved successfully with couponId: {}, discount:{}, lowerLimit: {}",
                coupon.getId(), coupon.getDiscount(), coupon.getLowerLimit());
    }
    public void saveOnReadDB(Coupon coupon) {
        log.info("[saveOnReadDB] Coupon is saved successfully with couponId: {}, discount:{}, lowerLimit: {}",
                coupon.getId(), coupon.getDiscount(), coupon.getLowerLimit());
    }
}
