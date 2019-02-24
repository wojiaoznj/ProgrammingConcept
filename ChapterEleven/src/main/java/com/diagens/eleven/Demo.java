package com.diagens.eleven;

/**
 * @author ZNJ
 * @create 2019/2/24-17:29
 */
public class Demo {
    public static void main(String[] args) {
        A a = new C();
        try {
            a.findException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
