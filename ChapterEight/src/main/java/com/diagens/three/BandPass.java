package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019/2/15-23:12
 */
public class BandPass extends Filter {
    double lowCutoff,highCutoff;
    public BandPass(double lowCuto,double highCut){
        this.lowCutoff=lowCuto;
        this.highCutoff=highCut;
    }

    public Waveform process(Waveform input){
        return input;
    }
}
