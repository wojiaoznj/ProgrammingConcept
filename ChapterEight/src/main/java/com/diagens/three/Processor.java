package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019/2/17-21:24
 */
public interface Processor {
    String name();
    Object process(Object input);
}
