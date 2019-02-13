package com.diagens.seven;

/**
 * @author ZNJ
 * @create 2019/2/13-21:47
 */
public class TestStatic {
    public static String string1="sanmao";
    public static String string2;

    public static void printStr(){
        System.out.println(string1);
        System.out.println(string2);
    }
    static {
        string2="simao";
    }
}
