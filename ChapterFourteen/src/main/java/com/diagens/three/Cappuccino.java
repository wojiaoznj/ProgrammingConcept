package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019-02-27 13:41
 */
public class Cappuccino extends Coffee {
    public static class Factory implements com.diagens.three.Factory{
        public Coffee create() {
            return new Cappuccino();
        }
    }
}
