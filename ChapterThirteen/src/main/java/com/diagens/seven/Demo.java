package com.diagens.seven;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Proxy;

/**
 * @author ZNJ
 * @create 2019/2/26-21:10
 */
public class Demo {
    @Test
    public void test1(){
        Interface interface1=new RealObject();
        interface1.doSomething();
        interface1.somethingElse("bonobo");

        Interface interface2=new SimpleProxy(new RealObject());
        interface2.doSomething();
        interface2.somethingElse("bonobo");
    }

    public static void consumer(Interface iface){
       iface.doSomething();
       iface.somethingElse("bonobo");
    }

    @Test
    public void test2(){
        RealObject real=new RealObject();
        consumer(real);

        //创建动态代理
        //需要一个类加载器(通常可以从已经被加载的对象中获取其类加载器)
        //一个你希望该代理实现的接口列表(不是类或抽象类)
        //InvocationHandler接口的一个实现
        Interface proxy=(Interface)Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class},new DynamicProxyHandler(real));
        consumer(proxy);
    }

}
