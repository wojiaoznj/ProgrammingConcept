package com.diagens.three;

import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-25 16:46
 */
public class  EvenGenerator extends IntGenerator {
    private int currentEventValue=0;
    public  int next() {
        System.out.println(Thread.currentThread().getName());
        ++currentEventValue;
        Thread.yield();
        System.out.println(Thread.currentThread().getName());
        ++currentEventValue;
        return currentEventValue;
    }
    public static void main(String [] args){
        EvenChecker.test(new EvenGenerator());
    }
}
