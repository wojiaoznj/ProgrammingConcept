package com.diagens.three.concurrency;

/**
 * @author ZNJ
 * @create 2019-03-27 12:00
 */
public class PairChecker implements Runnable {
    private PairManager pm;

    public PairChecker(PairManager pm) {
        this.pm = pm;
    }

    public void run() {
      while (true){
          pm.checkCounter.incrementAndGet();
          pm.getPair().checkState();
      }
    }
}
