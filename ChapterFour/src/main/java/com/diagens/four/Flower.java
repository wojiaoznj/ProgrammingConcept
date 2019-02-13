package com.diagens.four;

/**
 * @author ZNJ
 * @create 2019-02-13 17:03
 */
public class Flower {
    private String name;

    public Flower() {
        this("sanmao");
        System.out.println("Constructor No args");
    }

    public Flower(String name) {
        System.out.println("Constructor args is:"+name);
    }
}
