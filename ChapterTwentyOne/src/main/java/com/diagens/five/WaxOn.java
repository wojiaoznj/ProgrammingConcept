package com.diagens.five;

import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-28 10:42
 */
//打蜡
public class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax On!");
                TimeUnit.MILLISECONDS.sleep(200);
                //打蜡结束后，改变状态
                car.waxed();
                //等待抛光，抛光结束后才能继续打蜡
                car.waitForBuffing();
            }
        }catch(InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On Task");
    }
}
