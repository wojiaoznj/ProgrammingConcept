package com.diagens.four;

/**
 * @author ZNJ
 * @create 2019-02-26 15:28
 */
public class CabinAirFilter extends Filter {
    public static class Factory implements com.diagens.four.Factory<CabinAirFilter>{
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}
