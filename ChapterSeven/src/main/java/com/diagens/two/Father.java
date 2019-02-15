package com.diagens.two;

/**
 * @author ZNJ
 * @create 2019-02-15 15:50
 */
public class Father {
    public int field=0;
    public static int i=pr();

    public void play(){
        swim();
    }

    public void swim(){
        System.out.println("Father()...");
    }

    public static int pr(){
        System.out.println("ww11");
        return 0;
    }
}
