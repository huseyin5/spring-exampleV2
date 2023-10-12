package com.haydikodlayalim.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.haydikodlayalim.aop.services.MessageService.getMessage(..))")
    public void beforeMessageMethod(JoinPoint joinPoint) {
        System.out.println("Mesaj ver metodundan önce parametre yakalandı param: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* com.haydikodlayalim.aop.services.*.*(..))")
    public void afterMessageMethod(JoinPoint joinPoint) {
        System.out.println("Mesaj ver metodundan sonra parametre yakalandı param: " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }
}
