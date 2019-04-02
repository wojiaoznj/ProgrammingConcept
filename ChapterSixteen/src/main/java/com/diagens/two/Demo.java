package com.diagens.two;

import org.junit.Test;

import java.util.*;

/**
 * @author ZNJ
 * @create 2019-03-06 10:29
 */
public class Demo {
    @Test
    public void test1() {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list1 = new LinkedList<Integer>();
        genator(list);
        genator(list1);
        System.out.println(list);
        System.out.println(list1);
        Collections.shuffle(list);
        Collections.shuffle(list1);
        System.out.println(list);
        System.out.println(list1);
        Collections.shuffle(list);
        Collections.shuffle(list1);
        System.out.println(list);
        System.out.println(list1);
        Collections.shuffle(list);
        Collections.shuffle(list1);
        System.out.println(list);
        System.out.println(list1);
    }

    public static List<Integer> genator(List<Integer> list) {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(100));
        }
        return list;
    }
}
