package com.diagens.three.concurrency;

/**
 * @author ZNJ
 * @create 2019-03-27 11:56
 */
public class PairManager2 extends PairManager {
    public void increment() {
       Pair temp;
       synchronized (this){
           p.incrementY();
           p.incrementX();
           temp=getPair();
       }
       store(temp);
    }
}
