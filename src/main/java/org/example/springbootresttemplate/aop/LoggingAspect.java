package org.example.springbootresttemplate.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

//    return type fully qualified clz name.method name(args)
    @Before("execution(* org.example.springbootresttemplate.service.JobService.*(..))")
    public void logMethodCall(JoinPoint jp){
        LOGGER.info("Method called " + jp.getSignature().getName());
    }

    @After("execution(* org.example.springbootresttemplate.service.JobService.*(..)) || execution(* org.example.springbootresttemplate.JobRestController.*(..))")
    public void logMethodExecute(JoinPoint jp){
        LOGGER.info("Method executed " + jp.getSignature().getName());
    }
}
