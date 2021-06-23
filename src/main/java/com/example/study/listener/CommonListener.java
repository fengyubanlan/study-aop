package com.example.study.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @ClassName CommonListener
 * @Description TODO
 * @Author Jade
 * @Date 2021/06/22 11:07:03
 * @Version 1.0
 **/
@Slf4j
@Component
public class CommonListener implements ServletContextListener {


    @Value("${spring.profiles.active}")
    private String env;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("contextInitialized:env:"+env);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("contextDestroyed:2");
    }

}
