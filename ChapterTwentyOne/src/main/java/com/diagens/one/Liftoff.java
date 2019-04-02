package com.diagens.one;

/**
 * @author ZNJ
 * @create 2019-03-22 16:45
 */
public class Liftoff implements Runnable {
    protected int countDown=10;
    private static int taskCount=0;
    private final int id=taskCount++;

    public Liftoff() {
    }

    public Liftoff(int countDown) {
        this.countDown = countDown;
    }

    private String status(){
        return "#"+id+"("+
                (countDown>0?countDown+"),":"Liftoff!)");
    }

    public void run() {
        while (countDown-->0){
            System.out.print(status());
            //将CPU执行权传给另一个线程
            Thread.yield();
        }
        System.out.println();
    }
}
