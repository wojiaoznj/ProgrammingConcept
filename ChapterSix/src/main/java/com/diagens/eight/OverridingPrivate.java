package com.diagens.eight;

/**
 * @author ZNJ
 * @create 2019/2/14-22:47
 */
public class OverridingPrivate extends WithFinals {
    private final void f(){
        System.out.println("OverridingPrivate.()");
    }
    
    private void g(){
        System.out.println("OverridingPrivate.g()");
    }
    
}
