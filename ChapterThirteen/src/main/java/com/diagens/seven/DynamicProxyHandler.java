package com.diagens.seven;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ZNJ
 * @create 2019/2/26-21:12
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object proxiedl;

    public DynamicProxyHandler(Object proxiedl) {
        this.proxiedl = proxiedl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("*****proxy：" + proxy.getClass() +
                ",method: " + method +",args: "+args);
        if(args!=null){
           for (Object arg:args){
               System.out.println(" "+args);
           }
        }
        //proxiedl.method(args);
        return method.invoke(proxiedl,args);
    }
}
