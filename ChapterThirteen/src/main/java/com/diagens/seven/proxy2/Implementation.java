package com.diagens.seven.proxy2;

/**
 * @author ZNJ
 * @create 2019/2/26-21:34
 */
public class Implementation implements SomeMethods {
    @Override
    public void boring1() {
        System.out.println("boring1");
    }

    @Override
    public void boring2() {
        System.out.println("boring2");
    }

    @Override
    public void interesting(String arg,Integer integer) {
        System.out.println("interesting "+arg+integer);
    }

    @Override
    public void boring3() {
        System.out.println("boring3");
    }
}
