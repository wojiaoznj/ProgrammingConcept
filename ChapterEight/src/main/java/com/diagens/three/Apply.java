package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019/2/17-21:30
 */
public class Apply {
    public static void process(Processor processor,Object s){
        System.out.println("Using Processor "+ processor.name());
        System.out.println(processor.process(s));
    }
    
}
