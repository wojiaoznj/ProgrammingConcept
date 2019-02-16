package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019/2/15-23:11
 */
public class LowPass extends Filter {
    double cutoff;
    public LowPass(double cutoff){
        this.cutoff=cutoff;
    }

    public Waveform process(Waveform input){
        return input;
    }
}
