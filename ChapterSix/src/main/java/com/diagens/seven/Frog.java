package com.diagens.seven;

/**
 * @author ZNJ
 * @create 2019/2/14-22:05
 */
public class Frog extends Amphibian {
    @Override
    public void play(){
        System.out.println("play code");
    }


    public static void main(String[] args) {
       Frog frog=new Frog();
       Amphibian.tune(frog);
    }
}
