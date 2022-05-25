package com.microservice.cqrsmicroservicepattern.application;

public interface CouponHandler<I, T> {

    T sendQuery(I query);

    void sendCommand(I command);
}
