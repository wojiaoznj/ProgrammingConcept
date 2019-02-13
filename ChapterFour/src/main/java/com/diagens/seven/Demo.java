package com.diagens.seven;

import org.junit.jupiter.api.Test;

/**
 * @author ZNJ
 * @create 2019-02-13 20:26
 */
public class Demo {
    @Test
    public void test1(){
        //内部加载的顺序
        House house=new House();
    }

    @Test
    public void test2(){
       TestStatic.printStr();
    }

}
