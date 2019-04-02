package com.diagens.five;

/**
 * @author ZNJ
 * @create 2019-03-28 10:30
 */
//给这辆车打蜡和抛光，打蜡的结束后才能抛光，抛光后才能打蜡，首先要打一层蜡
public class Car {
    //判断是否打蜡
    private boolean waxOn=false;
    //打过蜡了，改变状态，并唤醒抛光任务
    public synchronized void waxed(){
        waxOn=true;
        notifyAll();
    }
    //抛过光了，改变状态，并唤醒打蜡任务
    public synchronized void buffed(){
        waxOn=false;
        notifyAll();
    }
    //等待打蜡结束
    public synchronized void waitForWaxing(){
        while (waxOn==false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //等待抛光结束
    public synchronized void waitForBuffing(){
        while (waxOn==true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
