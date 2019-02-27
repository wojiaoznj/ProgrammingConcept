package com.diagens.four;

/**
 * @author ZNJ
 * @create 2019-02-27 13:54
 */
public class GenericMethods {
    private static int count=0;
    private int id=count++;
    public String string;

    public <A,B,C> void f(A a,B b,C c){
        System.out.println(a+","+b+","+c);
    }

    public <A,C> void f(A a,String s,C c){
        System.out.println(a+","+s+","+c);
    }

    public String toString(){
        return getClass().getSimpleName()+" "+id;
    }
}
