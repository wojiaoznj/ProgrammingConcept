package com.diagens.four;

/**
 * @author ZNJ
 * @create 2019-02-26 15:28
 */
public class OilFilter extends Filter {
    public static class Factory implements com.diagens.four.Factory<OilFilter>{

        public OilFilter create() {
            return new OilFilter();
        }
    }
}
