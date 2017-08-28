package com.hoanghung.profilemanage.aopmonitoring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by hxhung on 8/28/2017.
 */
@Aspect
@Component
public class ServiceMonitoring {

    @Before("execution(* com.hoanghung..*endpoint.*(..))")
    public void logServiceAccessBefore(JoinPoint joinPoint) {
        System.out.println("Start: " + joinPoint);
    }

    @AfterReturning("execution(* com.hoanghung..*endpoint.*(..))")
    public void logServiceAccessAfter(JoinPoint joinPoint) {
        System.out.println("Completed: " + joinPoint);
    }
}
