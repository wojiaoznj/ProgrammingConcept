package com.diagens.two.Inner;

import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-25 11:11
 */
public class InnerRunnable1 {
    private int countDown = 5;
    private Inner inner;

    private class Inner implements Runnable {
        Thread thread;

        public Inner(String name) {
            thread = new Thread(this, name);
            thread.start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        @Override
        public String toString() {
            return thread.getName()+":"+countDown;
        }
    }
    public InnerRunnable1(String name){
        inner=new Inner(name);
    }
}
