package com.diagens.four;

/**
 * @author ZNJ
 * @create 2019-02-26 15:31
 */
public class GeneratorBelt extends Belt {
    public static class Factory implements com.diagens.four.Factory<GeneratorBelt>{

        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}
