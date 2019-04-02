package com.diagens.two;

import com.diagens.seven.Food;
import org.junit.Test;

/**
 * @author ZNJ
 * @create 2019-03-21 11:34
 */
public class Demo {
    @Test
    public void test1(){
        Food food= Food.Appetizer.SALAD;
        food= Food.MainCourse.LASAGNE;
        food=Food.Dessert.GELATO;
    }
}
