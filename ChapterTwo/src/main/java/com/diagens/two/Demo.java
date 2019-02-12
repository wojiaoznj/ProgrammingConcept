package com.diagens.two;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author ZNJ
 * @create 2019-02-12 15:51
 */
public class Demo {
    @Test
    public void test1() {
        //距离 m
        float diatance = 35467325;
        //时间 s
        float time = 24942;
        //速度
        float speed = diatance / time;
        System.out.println(speed+"m/s");
    }

    @Test
    public void test2(){
        Dog d1=new Dog();
        d1.setName("spot");
        d1.setSays("Ruff");

        Dog d2=new Dog();
        d2.setName("scruffy");
        d2.setSays("Wurf");

        System.out.println("这只狗的名字是:"+d1.getName()+",他的叫声是:"+d1.getSays());
        System.out.println("这只狗的名字是:"+d2.getName()+",他的叫声是:"+d2.getSays());

        Dog d3=d1;
        System.out.println("d3==d1:"+(d3==d1));
        System.out.println("d3.equals(d1):"+(d3.equals(d1)));
    }

    //抛硬币
    @Test
    public void test3(){
        Random random=new Random();
        for (int i=0;i<10;i++){
            if(random.nextInt(100)%2==0){
                System.out.println("抛出的硬币为正面");
            }else {
                System.out.println("抛出的硬币为反面");
            }
        }
    }

}
