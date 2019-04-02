package com.diagens.seven;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZNJ
 * @create 2019-03-29 15:08
 */
public class Demo {
    static final int count=100;
    public static void main(String [] args){
        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(count);
        for (int i = 0; i < 10; i++) {
            service.execute(new WaitingTask(latch));
        }

        for (int i = 0; i < count; i++) {
            service.execute(new TaskPortion(latch));
        }
        System.out.println("launched all tasks");
        service.shutdown();
    }
}
