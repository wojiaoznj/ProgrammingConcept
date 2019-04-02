package com.diagens.five.queues;

/**
 * @author ZNJ
 * @create 2019-03-28 17:39
 */
public class Butterer implements Runnable {
    private ToastQueue dryQueue, butteredQueue;

    public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
        this.dryQueue = dryQueue;
        this.butteredQueue = butteredQueue;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast take = dryQueue.take();
                take.butter();
                System.out.println(take);
                butteredQueue.put(take);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Butterer off");
    }
}
