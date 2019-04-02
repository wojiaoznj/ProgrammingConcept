package com.diagens.one;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author ZNJ
 * @create 2019-03-21 19:24
 */
public class Demo {
    @UserCase(id = 47,description = "Passwords must contain at least one numeric")
    public void test1(){
        System.out.println("User Annotation");
    }
    @UserCase(id = 48)
    public void test2(){
        System.out.println("User Annotation");
    }
    @UserCase(id = 49,description = "New passwords can't equals previously used ones")
    public void test3(){
        System.out.println("User Annotation");
    }

    @Test
    public void test4(){
        //循环该类下的所有方法
        for(Method m:Demo.class.getDeclaredMethods()){
            //得到该方法中使用注解usercase的实例
            UserCase annotation = m.getAnnotation(UserCase.class);
            //没用注解的则实例为空
            if(annotation!=null){
                System.out.println(annotation.id()+":"+annotation.description());
            }
        }
    }
}
