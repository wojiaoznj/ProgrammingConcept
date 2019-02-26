package com.diagens.seven.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ZNJ
 * @create 2019/2/26-21:31
 */
public class MethodSelector implements InvocationHandler {
    public Object proxied;

    public MethodSelector(Object proxied) {
        this.proxied = proxied;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("interesting")){
            System.out.println("Proxy detected the interesting method");
        }
        return method.invoke(proxied,args);
    }
}
