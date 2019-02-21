package com.diagens.seven;

/**
 * @author ZNJ
 * @create 2019-02-20 18:59
 */
public class ParcelSeven {
    private static class ParcelContents{
        private String label;
        private ParcelContents(String whereTo){
            label=whereTo;
        }

        private static void f(String label){
            System.out.println(label);
        }
    }

    public static void main(String [] args){
        new ParcelContents("Hello");
        ParcelContents.f("World");
    }

}
