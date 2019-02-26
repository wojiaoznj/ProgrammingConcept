package com.diagens.seven;

/**
 * @author ZNJ
 * @create 2019/2/26-21:08
 */
public class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied) {
        this.proxied = proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();
    }

    @Override
    public void somethingElse(String arg) {
        System.out.println("SimpleProxy somethingElse "+arg);
        proxied.somethingElse(arg);
    }
}
