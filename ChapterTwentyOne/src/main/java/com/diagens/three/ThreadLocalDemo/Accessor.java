package com.diagens.three.ThreadLocalDemo;

/**
 * @author ZNJ
 * @create 2019-03-27 14:30
 */
public class Accessor implements Runnable {
    private final int id;

    public Accessor(int idn){
        id=idn;
    }

    public void run() {
       while (!Thread.currentThread().isInterrupted()){
           ThreadLocalVariableHolder.increment();
           System.out.println(this);
           Thread.yield();
       }
    }

    @Override
    public String toString() {
        return "Accessor{" +
                "id=" + id +":"+ThreadLocalVariableHolder.get()+
                '}';
    }
}
