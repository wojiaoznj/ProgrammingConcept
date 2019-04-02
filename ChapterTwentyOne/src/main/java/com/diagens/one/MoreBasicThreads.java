package com.diagens.one;

/**
 * @author ZNJ
 * @create 2019-03-22 17:20
 */
public class MoreBasicThreads {
    public static void main(String [] args){
        for (int i = 0; i < 2; i++) {
            new Thread(new Liftoff()).start();
        }
        System.out.println("Waiting for Liftoff");
    }
}
