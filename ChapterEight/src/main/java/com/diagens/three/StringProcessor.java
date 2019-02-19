package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019/2/17-21:33
 */
public abstract class StringProcessor implements Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    public abstract String process(Object input);
    public static String s="If she weights the same as duck,she's made of wood";
}
