package com.microservice.cqrsmicroservicepattern.application.query.handler;

import com.microservice.cqrsmicroservicepattern.application.query.SearchCouponQuery;
import com.microservice.cqrsmicroservicepattern.domain.Coupon;
import com.microservice.cqrsmicroservicepattern.infrastructure.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchCouponQueryHandler implements CouponQueryHandler<SearchCouponQuery, Coupon> {

    private final CouponRepository couponRepository;

    @Override
    public Coupon execute(SearchCouponQuery query) {
        return couponRepository.search(query.price());
    }

    @Override
    public boolean isMatched(String className) {
        return className.equals(SearchCouponQuery.class.getSimpleName());
    }
}
