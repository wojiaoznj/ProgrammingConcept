package com.diagens.four;

/**
 * @author ZNJ
 * @create 2019-02-26 15:30
 */
public class PowerSteerinBelt extends Belt {
    public static class Factory implements com.diagens.four.Factory<PowerSteerinBelt>{

        public PowerSteerinBelt create() {
            return new PowerSteerinBelt();
        }
    }
}
