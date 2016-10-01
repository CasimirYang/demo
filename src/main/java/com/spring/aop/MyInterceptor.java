package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * Created by yjh on 16/9/30.
 */
@Aspect
@Component
public class MyInterceptor implements Ordered {

    //第一个* 代表任意返回值, .. 代表任意参数
    //符合条件的才被切入
    @Pointcut("execution(* com.spring.aop.PersonServer.*(..))")
    private void anyMethod(){}//定义一个切入点


    @Before("anyMethod() && args(name,param2)")
    public void doAccessCheck(String name,int param2){
        System.out.println(name);
        System.out.println(param2);
        System.out.println("前置通知");
    }

    @AfterReturning("anyMethod()")
    public void doAfter(){
        System.out.println("后置通知");
    }

    @AfterThrowing("anyMethod()")
    public void doAfterThrow(){
        System.out.println("例外通知");
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("进入环绕通知");
        Object object = pjp.proceed();//执行该方法
        System.out.println("退出方法");
        return object;
    }

    //order 的值越小，说明越先被执行。
    //transaction-manager 也要设置order保证大小
    @Override
    public int getOrder() {
        return 2;
    }
}
