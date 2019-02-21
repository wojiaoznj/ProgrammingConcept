package com.diagens.seven;

/**
 * @author ZNJ
 * @create 2019-02-20 19:14
 */
public interface Parcel {
    void printStr();

    public static class TestStatic implements Parcel{

        public void printStr() {
            System.out.println("Hello,World");
        }
    }
}
