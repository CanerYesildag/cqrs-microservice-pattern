package com.microservice.cqrsmicroservicepattern.application.command.handler;

import com.microservice.cqrsmicroservicepattern.application.command.UpdateCouponCommand;
import com.microservice.cqrsmicroservicepattern.domain.Coupon;
import com.microservice.cqrsmicroservicepattern.infrastructure.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCouponCommandHandler implements CouponCommandHandler<UpdateCouponCommand> {

    private final CouponRepository couponRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void execute(UpdateCouponCommand command) {
        Coupon coupon = couponRepository.getById(command.id());
        coupon.setDiscount(command.discount());
        coupon.setLowerLimit(command.lowerLimit());
        couponRepository.saveOnWriteDB(coupon);
        eventPublisher.publishEvent(coupon);
    }

    @Override
    public boolean isMatched(String className) {
        return className.equals(UpdateCouponCommand.class.getSimpleName());
    }
}
