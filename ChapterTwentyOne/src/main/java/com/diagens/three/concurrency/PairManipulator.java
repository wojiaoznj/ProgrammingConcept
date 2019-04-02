package com.diagens.three.concurrency;

/**
 * @author ZNJ
 * @create 2019-03-27 11:58
 */
public class PairManipulator implements Runnable {
    private PairManager pm;

    public PairManipulator(PairManager pm) {
        this.pm = pm;
    }

    public void run() {
       while (true){
           pm.increment();
       }
    }

    @Override
    public String toString() {
        return "Pair:"+pm.getPair()+
                "checkCounter="+pm.checkCounter.get();
    }
}
