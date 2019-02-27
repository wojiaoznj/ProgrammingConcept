package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019-02-27 13:39
 */
public class Latte extends Coffee {
    public static class Factory implements com.diagens.three.Factory{
        public Coffee create() {
            return new Latte();
        }
    }
}
