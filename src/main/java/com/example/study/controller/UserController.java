package com.example.study.controller;

import com.example.study.interceptor.ApiIdempotent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Jade
 * @Date 2021/06/22 11:20:27
 * @Version 1.0
 **/
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @ApiIdempotent
    @ResponseBody
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(@RequestParam("q") String q){
        log.info("CommonController:hello:q:"+q);
        return "hello";
    }

}
