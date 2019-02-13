package com.diagens.three;

import org.junit.jupiter.api.Test;

/**
 * @author ZNJ
 * @create 2019-02-13 16:23
 */
public class Demo {

    @Test
    public void test(){
       Bird bird=new Bird("sanmao");
    }

    @Test
    public void test1(){
        Dog dog=new Dog("wangcai");
        //当Dog类中没有自定义的构造器，程序默认会创建一个无参的构造器
        //当Dog类中有自定义的构造器，则不允许直接创建一个无参对象
        //Dog dog1=new Dog();
    }
}
