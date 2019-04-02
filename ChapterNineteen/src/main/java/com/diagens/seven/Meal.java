package com.diagens.seven;

/**
 * @author ZNJ
 * @create 2019-03-21 13:10
 */
public enum  Meal {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class);

    private Food[] values;

    Meal(Class<? extends  Food> kind) {
        values=kind.getEnumConstants();
    }

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

    public Food randomSelection(){
        return Enums.random(values);
    }

    public static void main(String [] args){
        for (int i = 0; i < 5; i++) {
            for (Meal meal : Meal.values()) {
                Food food=meal.randomSelection();
                System.out.println(food);
            }
            System.out.println("-------------");
        }
    }
}
