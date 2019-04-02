package com.diagens.two.join;

/**
 * @author ZNJ
 * @create 2019-03-25 12:00
 */
public class Joiner extends Thread {
    private Sleeper sleeper;
    public Joiner(String name,Sleeper sleeper){
        super(name);
        this.sleeper=sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            //Sleeper对应的线程运行，当前线程挂起，等Sleeper线程运行结束后，当前线程继续运行
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName()+"join completed");
    }
}
