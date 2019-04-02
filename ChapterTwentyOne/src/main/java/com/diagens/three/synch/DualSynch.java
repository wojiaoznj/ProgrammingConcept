package com.diagens.three.synch;

/**
 * @author ZNJ
 * @create 2019-03-27 13:56
 */
public class DualSynch {
    private Demo syncObject = new Demo();

    public synchronized void a() {
        for (int i = 0; i < 5; i++) {
            System.out.println("a()");
            Thread.yield();
        }
    }

    public void b() {
        synchronized (Object.class) {
            for (int i = 0; i < 5; i++) {
                System.out.println("b()");
                Thread.yield();
            }
        }
    }

    public void c() {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                System.out.println("c()");
                Thread.yield();
            }
        }
    }
}
