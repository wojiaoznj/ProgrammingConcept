package com.diagens.seven;

import java.util.Random;

/**
 * @author ZNJ
 * @create 2019-03-21 13:17
 */
public class Enums {
    public static Random random=new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec){
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values){
        return values[random.nextInt(values.length)];
    }
}
