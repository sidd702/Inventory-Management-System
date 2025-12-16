package com.sidd.product_service.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogExecutionTimeAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogExecutionTimeAspect.class);

    @Around("@annotation(com.sidd.product_service.customannotation.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        LOGGER.info("{} Executed in {} MS",
                joinPoint.getSignature().toShortString(),
                executionTime);

        return result;
    }

}
