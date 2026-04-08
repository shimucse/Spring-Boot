package com.lov2code.springboot.thymleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLogginAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.lov2code.springboot.thymleafdemo.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.lov2code.springboot.thymleafdemo.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.lov2code.springboot.thymleafdemo.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint theJoinPoint){

        String method = theJoinPoint.getSignature().toShortString();

       myLogger.info("========================================>>> AOP BEFORE: " + method);
       //display the arguments to the method

        //get the arguments
        Object[] args = theJoinPoint.getArgs();

        //loop thru and display args
        for(Object tempArg:args ){
            myLogger.info("================>>argument: "+tempArg);
        }
    }
    //add @AfterReturing advice
    @AfterReturning(
            pointcut = "forAppFlow()",
            returning = "")
    public void afterReturning(JoinPoint theJoinPoint, Object theResult){
          //display method we are returning from
        String method = theJoinPoint.getSignature().toShortString();

        myLogger.info("========================================>>> in @AfterReturning:from method : " + method);
          //display data returned
        myLogger.info("===========> result: "+ theResult);

     }

}
