package com.example.study.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName CommonFilter
 * @Description TODO
 * @Author Jade
 * @Date 2021/06/22 11:10:50
 * @Version 1.0
 **/
@Slf4j
@Component
public class CommonFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("CommonFilter:doFilter");
        HttpServletRequest request =(HttpServletRequest) servletRequest;
        Map<String,String[]> parameterMap = request.getParameterMap();
        Map<String,String[]> map = new HashMap<>();
        Set<String> keys =  parameterMap.keySet();
        for (String key : keys){
            log.info("CommonFilter:key:"+key+",value:"+parameterMap.get(key)[0]);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
