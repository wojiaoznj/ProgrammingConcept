package com.diagens.six;

/**
 * @author ZNJ
 * @create 2019/2/24-22:56
 */
public class IntegerMatch {
    public static void main(String[] args) {
        //可能以一个"-"开头,1个或多个数字
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("+1234".matches("-?\\d+"));
        //可能以一个"-"或"+"开头,1个或多个数字
        System.out.println("+1234".matches("(-|\\+)?\\d+"));
    }
}
