package com.diagens.six;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * @author ZNJ
 * @create 2019-02-26 17:18
 */
public class ShowMethods {
    private static Pattern p=Pattern.compile("(\\w+\\.)|final|native");
    //查看此类定义的方法
    public static void main(String[] args) {
        try {
            Class<?> c=Class.forName("com.diagens.six.ShowMethods");
            Method[] methods=c.getMethods();
            Constructor[] constructors=c.getConstructors();

            for (Method method : methods) {
                //method:public static void com.diagens.six.ShowMethods.main(java.lang.String[])
                //method:public static void main(String[])
                System.out.println(p.matcher("method:"+method.toString()).replaceAll(""));
            }

            for (Constructor constructor : constructors) {
                System.out.println(p.matcher("constructor:"+constructor).replaceAll(" "));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
