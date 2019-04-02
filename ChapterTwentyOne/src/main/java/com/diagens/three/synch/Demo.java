package com.diagens.three.synch;

/**
 * @author ZNJ
 * @create 2019-03-27 13:58
 */
public class Demo {
    public static void main(String [] args){
        final DualSynch ds=new DualSynch();
        new Thread(){
            @Override
            public void run() {
                ds.a();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                ds.b();
            }
        }.start();

        ds.c();
    }
}
