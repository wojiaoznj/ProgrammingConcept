package com.diagens.seven;

/**
 * @author ZNJ
 * @create 2019-03-21 11:29
 */
//都是食物，食物有不同的分类
public interface Food {
    enum Appetizer implements  Food{
        SALAD,SOUP,SPRING_ROLLES;
    }
    enum MainCourse implements Food{
        LASAGNE,BURRITO,PAD_THAI,
        LENTILS,HUMMOUS,VINDALOO;
    }
    enum Dessert implements Food{
        TIRAMISU,GELATO,BLACK_FOREST_CAKE,
        FRUIT,CREME_CARAMEL;
    }
}
