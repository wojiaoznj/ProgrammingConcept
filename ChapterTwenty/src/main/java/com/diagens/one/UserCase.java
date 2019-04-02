package com.diagens.one;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author ZNJ
 * @create 2019-03-21 19:21
 */
//用于指定你的注解定义在什么地方，方法或域
@Target(ElementType.METHOD)
//用于定义该注解在哪一个级别可用
@Retention(RetentionPolicy.RUNTIME)
public @interface UserCase {
    public int id();
    public String description() default "no description";
}
