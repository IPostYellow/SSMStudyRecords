package com.hj.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//方式三：使用注解方式实现AOP
@Component
@Aspect //标注这个类是一个切面
public class AnnotationPointCut {
    @Before("execution(* com.hj.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("方法执行前");
    }

    @After("execution(* com.hj.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("方法执行后");
    }

    @Around("execution(* com.hj.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        //执行方法
        Object proceed = jp.proceed();
        //类的信息
        Signature signature = jp.getSignature();
        System.out.println(signature);
        System.out.println("环绕后");
    }
}
