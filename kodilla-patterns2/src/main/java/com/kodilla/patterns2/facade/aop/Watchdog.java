package com.kodilla.patterns2.facade.aop;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Watchdog {
    private static final Logger LOGGER = LoggerFactory.getLogger(Watchdog.class);

    @Before(value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(order, userId) && target(object)", argNames = "order,userId,object")
    public void logEvent(OrderDto order, Long userId, Object object) {
        LOGGER.info("AOP before: " +
                        "Class: {}," +
                        " Args: order [{}], userId [{}]"
                , object.getClass().getName(), order, userId);
    }

    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("AOP around: Time consumed {} [ms]", (end - begin));
        } catch (Throwable throwable) {
            LOGGER.error("AOP around: {}", throwable.getMessage());
            throw throwable;
        }
        return result;
    }

    @AfterThrowing(pointcut="execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))", throwing="exception")
    public void logAfterThrowing(Throwable exception) {
        LOGGER.error("AOP after throwing: {}", exception.getMessage());
    }
}
