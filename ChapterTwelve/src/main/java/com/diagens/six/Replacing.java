package com.diagens.six;

/**
 * @author ZNJ
 * @create 2019/2/24-23:11
 */
public class Replacing {
    public static void main(String[] args) {
        //\w任意字母，以f开头的任意一个或多个单词替换为located
        //replaceFirst替换第一个
        System.out.println(Splitting.knights.replaceFirst("f\\w+",
                "located"));

        //将以下三个单词替换为apple
        //replaceAll替换全部
        System.out.println(Splitting.knights.replaceAll(
                "shrubbery|tree|herring", "apple"));
    }
}
