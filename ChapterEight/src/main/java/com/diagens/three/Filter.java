package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019/2/15-23:10
 */
public class Filter {
    public String name(){
        return getClass().getSimpleName();
    }

    public Waveform process(Waveform input){
        return input;
    }
}
