package com.diagens.seven.CyclicBarrierDemo;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ZNJ
 * @create 2019-03-29 15:27
 */
//马匹赛跑
public class Horse implements Runnable {
    private static int count=0;
    //给马匹编号
    private final int id=count++;
    //每匹马跑的步数
    private int strides=0;
    private static Random random=new Random(47);
    private static CyclicBarrier barrier;

    public Horse(CyclicBarrier cb) {
        barrier=cb;
    }

    public synchronized int getStrides(){return strides;}

    public void run() {
       while (!Thread.interrupted()){
           synchronized (this){
               //每次跑的步数随机0 1 2
               strides+=random.nextInt(3);
           }
           try {
               //跑完一轮，等待其余马匹。等全部的马群都到位后，触发CyclicBarrier中run方法
               barrier.await();
           } catch (InterruptedException e) {
               e.printStackTrace();
           } catch (BrokenBarrierException e) {
               e.printStackTrace();
           }
       }
    }

    @Override
    public String toString() {
        return "Horse{" +
                "id=" + id +
                '}';
    }

    //绘制马跑的轨迹
    public String tracks(){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            sb.append("*");
        }
        sb.append(id);
        return sb.toString();
    }
}
