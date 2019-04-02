package com.diagens.two.join;

import org.omg.CORBA.TCKind;

/**
 * @author ZNJ
 * @create 2019-03-25 11:55
 */
public class Sleeper extends Thread {
    //休眠时间
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            //当sleep时，如果线程被调用了interrupted方法，则会进入catch方法
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted.isInterrupted():" + isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");
    }
}
