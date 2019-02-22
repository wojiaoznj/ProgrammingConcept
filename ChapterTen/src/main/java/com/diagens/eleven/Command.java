package com.diagens.eleven;

/**
 * @author ZNJ
 * @create 2019-02-22 16:20
 */
public class Command {
    private String name;

    public Command(String name) {
        this.name = name;
    }

    public void operation(){
        System.out.println(name);
    }
}
