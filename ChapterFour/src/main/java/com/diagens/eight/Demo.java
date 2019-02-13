package com.diagens.eight;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author ZNJ
 * @create 2019/2/13-22:08
 */
public class Demo {
    @Test
    public void test1() {
        Integer[] a = {
                new Integer(1),
                new Integer(2),
                3
        };

        Integer[] b = new Integer[]{
                new Integer(1),
                2,
                3
        };
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void test2(){
        f("a","b","c","d");
    }

    private void f(String...strings){
        for(String str:strings){
            System.out.print(str);
        }
    }

}
