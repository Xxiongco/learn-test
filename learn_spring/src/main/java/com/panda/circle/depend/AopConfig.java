package com.panda.circle.depend;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopConfig {

    @Pointcut("execution(public * com.panda.circle.depend.*.hello(..))")
    public void myMethod(){};

    @Around("myMethod()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("-----------------before-------------------");
        Object result = point.proceed();
        System.out.println("-----------------after-------------------");
        return result;
    }


}
