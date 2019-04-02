package com.diagens.three.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-27 12:01
 */
public class CriticalSection {
    static void testApproaches(PairManager pman1,PairManager pman2){
        ExecutorService executorService = Executors.newCachedThreadPool();
        PairManipulator
                pm1=new PairManipulator(pman1),
                pm2=new PairManipulator(pman2);
        PairChecker
                pCheck1=new PairChecker(pman1),
                pCheck2=new PairChecker(pman2);
        executorService.execute(pm1);
        executorService.execute(pm2);
        executorService.execute(pCheck1);
        executorService.execute(pCheck2);
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("pm1:"+pm1+"\npm2:"+pm2);
        System.exit(0);
    }

    public static void main(String [] args){
        PairManager
                pman1=new PairManager1(),
                pman2=new PairManager2();
        testApproaches(pman1,pman2);
    }
}
