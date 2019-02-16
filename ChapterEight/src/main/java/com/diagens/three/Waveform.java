package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019/2/15-23:09
 */
public class Waveform {
    private static long counter;
    private final long id=counter++;

    @Override
    public String toString() {
        return "Waveform"+id;
    }
}
