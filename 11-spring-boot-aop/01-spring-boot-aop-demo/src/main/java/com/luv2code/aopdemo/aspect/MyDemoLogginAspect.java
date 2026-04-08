package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {
    //this is where we add all of our related advices for logging
    //let's start with an @Before advice
    //@Before("execution(public void addAccount())")

   // @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
  /* @Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=====>>> Executing @Before advice on method()");
    }
   @AfterReturning(
           pointcut = "execution(* com.luv2code.aopdemo.dao.*.*(..))",
           returning = "result"
   )
   public void afterReturningAdvice(Object result){
       System.out.println("\n=====>>> Result: " + result);
   }

   @AfterThrowing(
           pointcut = "execution(* com.luv2code.aopdemo.dao.*.*(..))",
           throwing = "exc"
   )
    public void afterThrowingAdvice(Throwable exc){
        System.out.println("\n======>>>Exception: "+exc);
   }
*/

    @Around("execution(* com.luv2code.aopdemo.dao.*.*(..))")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {

        String method = joinPoint.getSignature().toShortString();

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // 🔥 VERY IMPORTANT

        long end = System.currentTimeMillis();

        System.out.println("\n======>>> Method: " + method);
        System.out.println("======>>> Execution time: " + (end - start) + " ms");

        return result;
    }

}
