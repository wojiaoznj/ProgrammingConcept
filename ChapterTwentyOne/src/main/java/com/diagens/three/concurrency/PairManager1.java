package com.diagens.three.concurrency;

/**
 * @author ZNJ
 * @create 2019-03-27 11:55
 */
public class PairManager1 extends PairManager {
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
