package com.diagens.eight;

/**
 * @author ZNJ
 * @create 2019/2/14-22:50
 */
public class FinalOverridingIllusion {
    public static void main(String[] args) {
       OverridingPrivate2 op2=new OverridingPrivate2();
       op2.f();
       op2.g();

       OverridingPrivate op=op2;
       //op.f();
       //op.g();
    }
}
