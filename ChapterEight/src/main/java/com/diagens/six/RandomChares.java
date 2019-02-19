package com.diagens.six;

import java.util.Random;

/**
 * @author ZNJ
 * @create 2019/2/17-23:01
 */
public class RandomChares {
    private static Random random=new Random();
    public char next(){
        return (char)('a'+random.nextInt(26));
    }
}
