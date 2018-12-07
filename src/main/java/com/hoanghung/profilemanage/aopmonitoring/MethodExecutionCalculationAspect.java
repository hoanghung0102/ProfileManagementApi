package com.hoanghung.profilemanage.aopmonitoring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

    @Around("@annotation(com.hoanghung.profilemanage.custom.anotation.TrackTime)")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        joinPoint.proceed();

        long timeTaken = System.currentTimeMillis()  - startTime;
        System.out.println("Time taken by " + joinPoint + " is " + timeTaken);
    }
}
