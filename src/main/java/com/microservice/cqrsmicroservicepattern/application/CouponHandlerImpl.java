package com.microservice.cqrsmicroservicepattern.application;

import com.microservice.cqrsmicroservicepattern.application.command.CouponCommandHandlerFactory;
import com.microservice.cqrsmicroservicepattern.application.query.CouponQueryHandlerFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponHandlerImpl implements CouponHandler<Object, Object> {

    private final CouponQueryHandlerFactory queryHandlerFactory;
    private final CouponCommandHandlerFactory commandHandlerFactory;

    @Override
    public Object sendQuery(Object query) {
        return queryHandlerFactory.getHandler(query.getClass()).execute(query);
    }

    @Override
    public void sendCommand(Object command) {
        commandHandlerFactory.getHandler(command.getClass()).execute(command);
    }
}
