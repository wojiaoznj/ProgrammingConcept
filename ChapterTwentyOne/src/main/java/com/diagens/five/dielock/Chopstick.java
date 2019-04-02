package com.diagens.five.dielock;

/**
 * @author ZNJ
 * @create 2019-03-29 13:17
 */
public class Chopstick {
    private boolean taken=false;

    //拿起筷子
    public synchronized void take() throws InterruptedException {
        while (taken){
            wait();
        }
        taken=true;
    }

    //放下筷子
    public synchronized void drop(){
        taken=false;
        notifyAll();
    }
}
