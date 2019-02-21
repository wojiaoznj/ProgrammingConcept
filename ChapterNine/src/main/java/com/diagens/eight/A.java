package com.diagens.eight;

/**
 * @author ZNJ
 * @create 2019-02-20 20:12
 */
public class A {
    public U generateU(){
        return new U() {
            public void u1() {
                System.out.println("a.u1");
            }

            public void u2() {
                System.out.println("a.u2");
            }

            public void u3() {
                System.out.println("a.u3");
            }
        };
    }
}
