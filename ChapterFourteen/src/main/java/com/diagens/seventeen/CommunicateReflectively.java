package com.diagens.seventeen;

import java.lang.reflect.Method;

/**
 * @author ZNJ
 * @create 2019-03-04 16:57
 */
public class CommunicateReflectively {
    public static void perform(Object speaker){
        Class<?> spkr=speaker.getClass();
        try {
            try {
                Method speak=spkr.getMethod("speak");
                speak.invoke(speaker);
            }catch (Exception e){
                System.out.println(speaker+" cannot speak");
            }

            try {
                Method sit=spkr.getMethod("sit");
                sit.invoke(speaker);
            }catch (Exception e){
                throw new RuntimeException(speaker.toString(),e);
            }
        }catch (Exception e){

        }
    }

    public static void main(String [] args){
       CommunicateReflectively.perform(new SmartDog());
       CommunicateReflectively.perform(new Mime());
    }
}
