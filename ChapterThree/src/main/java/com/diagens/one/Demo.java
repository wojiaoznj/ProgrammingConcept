package com.diagens.one;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.Scanner;

/**
 * @author ZNJ
 * @create 2019/2/12-22:50
 */
public class Demo {
    @Test
    public void test1() {
        int i = 1;
        while (i <= 100) {
            System.out.println(i++);
        }
    }

    @Test
    public void test2() {
        int pre = 0;
        int cur;
        Random random = new Random();
        for (int i = 0; i < 25; i++) {
            cur = random.nextInt(100);
            if (i != 0) {
                if (cur > pre) {
                    System.out.println("cur>pre:" + cur + "," + pre);
                } else if (cur < pre) {
                    System.out.println("cur<pre:" + cur + "," + pre);
                } else {
                    System.out.println("cur=pre:" + cur + "," + pre);
                }
            }
            pre = cur;
        }
    }
}