package com.diagens.two;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author ZNJ
 * @create 2019-02-15 15:42
 */
public class Demo {

    @Test
    public  void test1(){
        Rodent[] rodents = new Rodent[10];
        Random random = new Random();

        for (int i=0;i<10;i++){
            switch (random.nextInt(3)){
                case 0:
                    rodents[i]=new Gerbil();
                    break;
                case 1:
                    rodents[i]=new Hamster();
                    break;
                case 2:
                    rodents[i]=new Mouse();
                    break;
            }
        }

        for(int i=0;i<rodents.length;i++){
            rodents[i].name();
        }
    }

    @Test
    public void test2(){
        Father father=new Son();
        father.play();
        System.out.println(father.field);
    }

    @Test
    public void test3(){
        Son.print();
        Son.print();
    }
}
