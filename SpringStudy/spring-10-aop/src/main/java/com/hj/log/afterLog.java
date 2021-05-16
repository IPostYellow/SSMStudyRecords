package com.hj.log;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class afterLog  implements AfterReturningAdvice {
    //和before的差不多，多一个returnValue，执行后是可以获得那个方法的返回值的（执行前是没得获得的）
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了"+method.getName()+"方法，返回结果为："+returnValue);
    }
}
