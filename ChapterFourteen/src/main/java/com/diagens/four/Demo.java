package com.diagens.four;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ZNJ
 * @create 2019-02-27 13:55
 */
public class Demo {
    @Test
    public void test1(){
        GenericMethods gm=new GenericMethods();
        gm.f("1",10,false);
    }

    @Test
    public void test2(){
        GenericMethods gm=new GenericMethods();
        gm.f(1,"10",false);
    }

    //自动生成一个类对象
    @Test
    public void test3() throws InstantiationException, IllegalAccessException {
        Generator generator=new Generator(GenericMethods.class);
        for(int i=0;i<10;i++){
            System.out.println(generator.next().toString());
        }
    }
}
