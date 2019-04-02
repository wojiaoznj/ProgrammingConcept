package com.diagens.two.Inner;

/**
 * @author ZNJ
 * @create 2019-03-25 10:47
 */
public class InnerThread1 {
    private int countDown=5;
    private Inner inner;
    private class Inner extends Thread{
        public  Inner(String name){
            super(name);
            start();
        }
        @Override
        public String toString() {
            return getName()+":"+countDown;
        }

        @Override
        public void run() {
            try {
                while (true){
                    System.out.println(this);
                    if(--countDown==0){
                        return;
                    }
                    sleep(10);
                }
            }catch (Exception e){
               e.printStackTrace();
            }

        }
    }
    public InnerThread1(String name){
        inner=new Inner(name);
    }
}
