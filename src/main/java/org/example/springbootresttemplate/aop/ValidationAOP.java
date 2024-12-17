package org.example.springbootresttemplate.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAOP {
    public static final Logger LOGGER = LoggerFactory.getLogger(ValidationAOP.class);

    @Around("execution(* org.example.springbootresttemplate.service.JobService.getJob(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {
        if(postId < 0){
            LOGGER.info("postId is negative.. updating");
            postId = -postId;
            LOGGER.info("new value = "+ postId);
        }

        return jp.proceed(new Object[]{postId});
    }

}
