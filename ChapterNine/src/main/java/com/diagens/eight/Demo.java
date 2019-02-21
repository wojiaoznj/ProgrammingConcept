package com.diagens.eight;

/**
 * @author ZNJ
 * @create 2019-02-20 20:23
 */
public class Demo {
    public static void main(String [] args){
        U u1=new A().generateU();
        U u2=new A().generateU();
        U u3=new A().generateU();
        U u4=new A().generateU();
        U u5=new A().generateU();

        B b=new B();
        b.B1(u1);
        b.B1(u2);
        b.B1(u3);
        b.B1(u4);
        b.B1(u5);

        b.B3();
        b.B2();
    }
}
