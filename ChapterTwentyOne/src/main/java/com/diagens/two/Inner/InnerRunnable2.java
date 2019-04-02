package com.diagens.two.Inner;

import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-25 11:19
 */
public class InnerRunnable2 {
    private int countDown = 5;
    private Thread thread;
    public InnerRunnable2(String name){
        thread=new Thread(new Runnable() {
            public void run() {
              try {
                  while (true){
                      System.out.println(this);
                      if(--countDown==0){
                          return;
                      }
                      TimeUnit.MILLISECONDS.sleep(10);
                  }
              }catch (Exception e){
                  e.printStackTrace();
              }
            }

            @Override
            public String toString() {
                return Thread.currentThread().getName()+":"+countDown;
            }
        },name);
        thread.start();
    }
}
