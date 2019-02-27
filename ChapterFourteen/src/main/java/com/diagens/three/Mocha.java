package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019-02-27 13:40
 */
public class Mocha extends Coffee {
    public static class Factory implements com.diagens.three.Factory{
        public Coffee create() {
            return new Mocha();
        }
    }
}
