package com.diagens.four;

/**
 * @author ZNJ
 * @create 2019-02-26 15:29
 */
public class FanBelt extends Belt {
    public static class Factory implements com.diagens.four.Factory<FanBelt>{

        public FanBelt create() {
            return new FanBelt();
        }
    }
}
