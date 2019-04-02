package com.diagens.seven;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author ZNJ
 * @create 2019-03-05 17:08
 */
public class Demo {
    @Test
    public void test1(){
        Comparing[] comparing=new Comparing[5];
        Comparing[] comparing1=new Comparing[5];
        Arrays.fill(comparing,new Comparing(5));
        Arrays.fill(comparing1,new Comparing(5));
        System.out.println(Arrays.equals(comparing,comparing1));
    }

    @Test
    public void test2(){
        int[] [] [] ints={{{2,4,1,5},{3,1,2,4}},{{2,4,2,3},{4,5,3,1}}};
        int[] [] [] ints1={{{2,4,1,5},{3,1,2,4}},{{2,4,1,3},{4,5,3,1}}};
        System.out.println(Arrays.deepEquals(ints,ints1));
    }
}
