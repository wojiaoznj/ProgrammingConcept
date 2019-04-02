package com.diagens.five.queues;

/**
 * @author ZNJ
 * @create 2019-03-28 17:44
 */
public class Jammer implements Runnable {
    private ToastQueue butteredQueue, finishedQueue;

    public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
        this.butteredQueue = butteredQueue;
        this.finishedQueue = finishedQueue;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast take = butteredQueue.take();
                take.jam();
                System.out.println(take);
                finishedQueue.put(take);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Jammer off");
    }
}
