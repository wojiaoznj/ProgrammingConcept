package com.diagens.seven;

/**
 * @author ZNJ
 * @create 2019/2/26-21:07
 */
public class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("doSomething");
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("somethingElse "+arg);
    }
}
