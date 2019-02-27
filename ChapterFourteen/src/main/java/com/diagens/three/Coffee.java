package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019-02-27 13:35
 */
public class Coffee {
    private static int count=0;
    private int id=count++;

    @Override
    public String toString() {
        return getClass().getSimpleName()+" "+id;
    }
}
