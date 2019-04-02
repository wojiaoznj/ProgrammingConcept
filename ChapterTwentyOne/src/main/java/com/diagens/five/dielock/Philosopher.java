package com.diagens.five.dielock;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-29 13:19
 */
//每个哲学家要左右两个筷子
//每次吃饭前会思考一会
//一共只有五根筷子
//一共五个哲学家，等待别人吃完以后放下筷子，它才能吃
public class Philosopher implements Runnable {
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random random=new Random(47);

    private void pause() throws InterruptedException {
        if(ponderFactor==0){
            return;
        }
        TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactor*250));
    }
    public Philosopher(Chopstick left, Chopstick right, int id, int ponderFactor) {
        this.left = left;
        this.right = right;
        this.id = id;
        this.ponderFactor = ponderFactor;
    }

    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println(this+" thinking");
                pause();
                System.out.println(this+" grabbing right");
                right.take();
                System.out.println(this+" grabbing left");
                left.take();
                System.out.println(this+" eating");
                Thread.sleep(1000);
                right.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "id=" + id +
                '}';
    }
}
