package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019/2/17-21:47
 */
public class FilterProcessor {
    public static void main(String[] args) {
        Waveform w=new Waveform();
        Apply.process(new FilterAdapter(new LowPass(1.0)),w);
        Apply.process(new FilterAdapter(new BandPass(3.0,
                5.0)),w);
        Apply.process(new ExchangePass("lopu"),w);
    }
}
