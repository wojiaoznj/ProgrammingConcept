package com.diagens.one;

import org.junit.Test;

/**
 * @author ZNJ
 * @create 2019-03-22 16:50
 */
public class Demo {
    @Test
    public void test1(){
        Liftoff liftoff=new Liftoff();
        liftoff.run();
    }

   public static void main(String [] args){
       Thread thread=new Thread(new Liftoff());
       thread.start();
       System.out.println("waiting for Liftoff");
   }
}
