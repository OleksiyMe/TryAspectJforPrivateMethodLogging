package com.oleksiy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {
    Logger logger= LoggerFactory.getLogger(MyLoggingAspect.class);

   // @Pointcut("@annotation(com.oleksiy.annotation.MyLoggingAnnotation)")
    @Pointcut("execution(* com.oleksiy.runner.Runner.printSomething(..))")

    public void logIt(){}

    @Before("logIt()")
    public void doMyLogging(JoinPoint joinPoint){
        logger.warn("This AspectJ AOP Logging invoked BEFORE "+joinPoint.getSignature().toShortString());
    }
    @After("logIt()")
    public void doMyLoggingAfter(JoinPoint joinPoint){
        logger.warn("Method " +joinPoint.getSignature().toShortString() +" is done! Method parameter was "
                + "\""+joinPoint.getArgs()[0]+"\"");
    }



}
