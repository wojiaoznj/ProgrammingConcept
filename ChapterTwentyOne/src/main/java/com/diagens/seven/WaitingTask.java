package com.diagens.seven;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author ZNJ
 * @create 2019-03-29 15:06
 */
public class WaitingTask implements Runnable {
    private static int counter=0;
    private final int id=counter++;
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier passed for "+this);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public String toString() {
        return String.format("WaitingTask %1$-3d",id);
    }
}
