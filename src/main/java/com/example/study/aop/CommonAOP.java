package com.example.study.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ControllerAOP
 * @Description TODO
 * @Author Jade
 * @Date 2021/06/22 12:19:05
 * @Version 1.0
 **/
@Slf4j
@Aspect
@Component
public class CommonAOP {

    @Pointcut("execution(* com.example.*.controller.*Controller.*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void point(){

    }

    @Around("point()")
    public Object handlerControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("CommonAop:handler");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("CommonAop:handler:q"+request.getParameter("q"));
        return joinPoint.proceed();
    }
}
