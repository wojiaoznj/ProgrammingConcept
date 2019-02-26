package com.diagens.seven.proxy2;

import java.lang.reflect.Proxy;

/**
 * @author ZNJ
 * @create 2019/2/26-21:34
 */
public class Demo {
    public static void main(String[] args) {
       SomeMethods proxy= (SomeMethods) Proxy.newProxyInstance(SomeMethods.class.getClassLoader(),
               new Class[]{SomeMethods.class},new MethodSelector(new Implementation()));

       proxy.boring1();
       proxy.boring2();
       proxy.interesting("bonobo",5);
       proxy.boring3();
    }
}
