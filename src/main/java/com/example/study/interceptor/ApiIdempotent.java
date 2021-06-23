package com.example.study.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName ApiIdempotent
 * @Description TODO
 * @Author Jade
 * @Date 2021/06/23 09:39:10
 * @Version 1.0
 **/

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiIdempotent {

}
