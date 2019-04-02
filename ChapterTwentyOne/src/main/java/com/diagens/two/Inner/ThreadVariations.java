package com.diagens.two.Inner;

/**
 * @author ZNJ
 * @create 2019-03-25 11:28
 */
public class ThreadVariations {
    public static void main(String [] args){
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runTask();
    }
}
