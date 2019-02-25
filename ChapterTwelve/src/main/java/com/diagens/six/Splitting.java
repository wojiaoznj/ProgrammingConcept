package com.diagens.six;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author ZNJ
 * @create 2019/2/24-22:59
 */
public class Splitting {
    public static String knights = "Then, when you have found the shrubbery," +
            "you must cut down the mightiest tree in the forest... " +
            "with... a herring";

    public static void split(String regex) {
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    @Test
    public  void test1() {
        //分割匹配的字符串
        split(" ");
        //\W匹配非字母的字符，进行分割
        split("\\W+");
        //匹配n开头后非字母的字符
        split("n\\W+");
    }

    @Test
    public void test2(){
        //分割有the you的地方
        split("(the | you)+");
    }

    @Test
    public void test3(){
        //检查字符串是否以大写字母开头，以。结尾
        //.* .代表任意字符 *代表0个或多个字符
        System.out.println("Poooooo,iiawdaw。".matches("^[A-Z].*$"));
        System.out.println("Poooooo,iiawdaw".matches("^[A-Z].*$"));
        System.out.println("poooooo,iiawdaw。".matches("^[A-Z].*$"));
        System.out.println("poooooo,iiawdaw".matches("^[A-Z].*$"));
    }

    @Test
    public void test4(){
        //以下划线替换元音字母(aeiou)
        System.out.println(knights.replaceAll("(a|e|i|o|u)+","_"));
    }

    @Test
    public void test5(){
        String str="Java now has regular expressions";
        System.out.println(str.matches("^Java"));
        System.out.println(str.matches("\\Breg.*"));
        System.out.println(str.matches("n.w\\s+h(a|i)s"));
        System.out.println(str.matches("s?"));
        System.out.println(str.matches("s*"));
        System.out.println(str.matches("s+"));
        System.out.println(str.matches("s{4}"));
        System.out.println(str.matches("s{0,3}"));
    }
    
}
