package com.example.study.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redisTemplate封装
 *
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    public void setList(Object key,Object value){
        redisTemplate.opsForList().set(key,-1,value);
    }

}