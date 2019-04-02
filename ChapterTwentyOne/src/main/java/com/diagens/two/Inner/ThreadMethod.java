package com.diagens.two.Inner;

import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-25 11:22
 */
public class ThreadMethod {
    private int countDown=5;
    private Thread thread;
    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }
    public void runTask(){
        if(thread==null){
            thread=new Thread(name){
                public void run(){
                    try {
                        System.out.println(this);
                        if(--countDown==0){
                            return;
                        }
                        sleep(10);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

                @Override
                public String toString() {
                    return getName()+":"+countDown;
                }
            };
            thread.start();
        }
    }
}
