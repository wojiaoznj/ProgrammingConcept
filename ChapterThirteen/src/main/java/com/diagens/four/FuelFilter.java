package com.diagens.four;

/**
 * @author ZNJ
 * @create 2019-02-26 15:24
 */
public class FuelFilter extends Filter{
    public static class Factory implements com.diagens.four.Factory<FuelFilter>{
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}
