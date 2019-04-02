package com.diagens.five;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-28 10:52
 */
public class Demo {
    public static void main(String [] args) throws InterruptedException {
        Car car=new Car();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(new WaxOff(car));
        service.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        service.shutdownNow();
    }
}
