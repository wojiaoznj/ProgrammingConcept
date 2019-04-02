package com.diagens.five;

import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-28 10:48
 */
public class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    public void run() {
        try {
            while (!Thread.interrupted()){
                //等待打蜡，打蜡结束后才能继续抛光
                car.waitForWaxing();
                System.out.println("Wax Off!");
                TimeUnit.MILLISECONDS.sleep(200);
                //抛光结束后，改变状态
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off Task");
    }
}
