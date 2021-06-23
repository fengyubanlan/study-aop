package com.example.study.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @ClassName CommonInterceptor
 * @Description TODO
 * @Author Jade
 * @Date 2021/06/22 11:14:38
 * @Version 1.0
 **/
@Slf4j
@Component
public class CommonInterceptor implements HandlerInterceptor {

    /**
     * 在DispatcherServlet之前执行
     * @param request
     * @param response
     * @param handler
     * @return
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("CommonInterceptor:preHandle");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod= (HandlerMethod) handler;
        Method method=handlerMethod.getMethod();
        ApiIdempotent methodAnnotation=method.getAnnotation(ApiIdempotent.class);
        if (methodAnnotation != null){
            log.info("CommonInterceptor:preHandle:ApiIdempotent");
            String token = request.getParameter("token");
            log.info("CommonInterceptor:preHandle:ApiIdempotent:token:"+token);
        }
        return true;
    }

    /**
     * 在controller执行之后的DispatcherServlet之后执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws IOException {
        log.info("CommonInterceptor:postHandle");
        String q = request.getParameter("q");
        log.info("CommonInterceptor:postHandle:q:"+q);
        int status = response.getStatus();
        log.info("CommonInterceptor:postHandle:status:"+status);
    }

    /**
     * 在页面渲染完成返回给客户端之前执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.info("CommonInterceptor:afterCompletion");
    }
}
