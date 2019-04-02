package com.diagens.five.queues;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-28 17:34
 */
public class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count=0;
    private Random random=new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    public void run() {
       try {
           while (!Thread.interrupted()){
               TimeUnit.MILLISECONDS.sleep(100+random.nextInt(500));
               Toast t=new Toast(count++);
               System.out.println(t);
               toastQueue.put(t);
           }
       } catch (InterruptedException e) {
           System.out.println("Toaster interrupted");
       }
        System.out.println("Toaster off");
    }
}
