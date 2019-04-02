package com.diagens.five.dielock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-29 13:26
 */
//产生死锁
//哲学家思考的时间过短
//一起来争抢筷子，会造成的情况是，每个人手里一只筷子
//但都不能吃饭，同时都在等待另一个人吃完饭放下筷子
public class DeadlockingDiningPhilosophers {
    public static void main(String [] args) throws InterruptedException {
        int size=5;
        int ponder=0;
        ExecutorService service = Executors.newCachedThreadPool();
        Chopstick[] chopsticks = new Chopstick[5];
        for (int i = 0; i < size; i++) {
            chopsticks[i]=new Chopstick();
        }
        for (int i = 0; i < size; i++) {
            service.execute(new Philosopher(chopsticks[i],chopsticks[(i+1)%size],i,ponder));
        }
        TimeUnit.SECONDS.sleep(10);
        service.shutdownNow();
    }
}
