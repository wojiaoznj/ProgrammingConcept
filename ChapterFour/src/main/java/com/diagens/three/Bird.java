package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019-02-13 16:22
 */
public class Bird {
    private String name;

    public Bird(){
        System.out.println("恭喜你创建一个对象");
    }

    public Bird(String name) {
        this.name = name;
        System.out.println("恭喜你创建一个对象，对象名为:"+name);
    }
}
