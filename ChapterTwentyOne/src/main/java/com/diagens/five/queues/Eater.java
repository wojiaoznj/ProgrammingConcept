package com.diagens.five.queues;

/**
 * @author ZNJ
 * @create 2019-03-28 17:46
 */
public class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int counter = 0;

    public Eater(ToastQueue finishedQueue) {
        this.finishedQueue = finishedQueue;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast take = finishedQueue.take();
                if(take.getId() !=counter++||take.getStatus()!=Toast.Status.JAMMED){
                    System.out.println(">>>Error："+take);
                    System.exit(1);
                }else {
                    System.out.println("Chomp!"+take);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Eater off");
    }
}
