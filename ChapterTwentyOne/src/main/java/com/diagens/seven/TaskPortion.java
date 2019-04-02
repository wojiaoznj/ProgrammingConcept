package com.diagens.seven;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-29 15:03
 */
public class TaskPortion implements Runnable {
    private static int counter=0;
    private final int id=counter++;
    private static Random random=new Random(47);
    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            doWork();
            latch.countDown();
        } catch (InterruptedException e) {
        }
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
        System.out.println(this+" completed");
    }

    @Override
    public String toString() {
        return String.format("%1$-3d",id);
    }
}
