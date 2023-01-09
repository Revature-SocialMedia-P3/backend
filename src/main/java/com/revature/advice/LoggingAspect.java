package com.revature.advice;

import org.apache.logging.slf4j.SLF4JLogger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(SLF4JLogger.class);


    @Pointcut("within(com.revature..*)")
    public void pcLogAll(){}

    @Before(value = "pcLogAll()", argNames = "jp")
    public void logMethodStart(JoinPoint jp) {
        String methodArguments = Arrays.toString(jp.getArgs());

        logger.info("{} was successfully invoked at {} with the provided arguments: {}", extractClassMethodSignature(jp), LocalDateTime.now(), methodArguments);
    }

    @AfterReturning(pointcut = "pcLogAll()", returning = "returnedObject", argNames = "jp,returnedObject")
    public void logMethodReturn(JoinPoint jp, Object returnedObject) {
        logger.info("{} successfully returned at {} with value: {}", extractClassMethodSignature(jp), LocalDateTime.now(), returnedObject);
    }

    @AfterThrowing(pointcut = "pcLogAll()", throwing = "t", argNames = "jp,t")
    public void logMethodThrows(JoinPoint jp, Throwable t) {
        String throwableName = t.getClass().getName();

        logger.warn("{} was thrown in {} at {} with a ,message: {}", throwableName, extractClassMethodSignature(jp), LocalDateTime.now(), t.getMessage());
    }

    private String extractClassMethodSignature(JoinPoint jp) {
        return jp.getTarget().getClass().toString() + "#" + jp.getSignature().getName();
    }
}
