package com.diagens.four;

/**
 * @author ZNJ
 * @create 2019-02-26 15:27
 */
public class AirFilter extends Filter {
    public static class Factory implements com.diagens.four.Factory<AirFilter>{

        public AirFilter create() {
            return new AirFilter();
        }
    }
}
