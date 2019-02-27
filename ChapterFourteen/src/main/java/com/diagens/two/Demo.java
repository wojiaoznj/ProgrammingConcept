package com.diagens.two;

import org.junit.jupiter.api.Test;

import javax.sound.midi.Soundbank;

/**
 * @author ZNJ
 * @create 2019-02-27 11:00
 */
public class Demo {
    @Test
    public void test1(){
      SixTuple<Integer,String,Float,Character,Boolean,Integer> sixTuple=new SixTuple<Integer,String,Float,Character,Boolean,Integer>(1,"2",1.0f,'b',false,2*5);
      System.out.println(sixTuple);
    }

    @Test
    public void test2(){
        LinkedStack<String> linkedStack=new LinkedStack<String>();
        for(String s:"Phasers or stun!".split(" ")){
           linkedStack.push(s);
        }
        String s;
        while ((s=linkedStack.pop())!=null){
            System.out.println(s);
        }
    }
}
