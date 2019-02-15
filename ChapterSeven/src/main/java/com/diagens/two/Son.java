package com.diagens.two;

/**
 * @author ZNJ
 * @create 2019-02-15 15:51
 */
public class Son extends Father {
    public static int i=pr();
    public int i1=paly();

    private int paly() {
        System.out.println("paly()..");
        return 0;
    }

    public int field=1;
    @Override
    public void swim() {
        System.out.println("Son()...");
    }

    public static int pr() {
        System.out.println("ww");
        return 0;
    }

    public static void print(){
        System.out.println("Hello,World");
    }
}
