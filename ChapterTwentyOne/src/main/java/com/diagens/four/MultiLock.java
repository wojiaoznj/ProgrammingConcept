package com.diagens.four;

/**
 * @author ZNJ
 * @create 2019-03-27 17:05
 */
public class MultiLock {
    public synchronized void f1(int count) {
        if (count-- > 0) {
            System.out.println("f1() calling f2() with count " + count);
            f2(count);
        }
    }

    private synchronized void f2(int count) {
        if (count-- > 0) {
            System.out.println("f2() calling f1() with count " + count);
            f1(count);
        }
    }

    public static void main(String[] args) {
        final MultiLock ml = new MultiLock();
        new Thread() {
            @Override
            public void run() {
                ml.f1(10);
            }
        }.start();
    }
}
