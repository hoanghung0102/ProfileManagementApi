package com.hoanghung.profilemanage.aopmonitoring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hxhung on 8/28/2017.
 */
@Aspect
@Configuration
public class ServiceMonitoring {

    @Before("execution(* com.hoanghung.profilemanage.service.*.*(..))")
    public void logServiceAccessBefore(JoinPoint joinPoint) {
        System.out.println("Start: " + joinPoint);
    }

    @AfterReturning(value = "execution(* com.hoanghung.profilemanage.service.*.*(..))", returning = "result")
    public void logServiceAccessAfter(JoinPoint joinPoint, Object result) {
        System.out.println("Completed: " + joinPoint + "\n Value return is " + result);
    }
}
