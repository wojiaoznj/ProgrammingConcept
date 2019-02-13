package com.diagens.one;

import org.junit.jupiter.api.Test;

import java.security.acl.Group;
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

    @Test
    public void test3() {
        for (int i = 1; i <= 100; i++) {
            boolean flag = true;
            for (int i1 = 2; i1 < i; i1++) {
                if (i % i1 == 0) {
                    flag = false;
                    break;
                }
            }
            if (i <= 2 || flag) {
                System.out.println("此数是素数:" + i);
            }
        }
    }

    @Test
    public void test4() {
        int i = 0;
        outer:
        for (; true; ) {
            inner:
            for (; i < 10; i++) {
                System.out.println("i = " + i);
                if (i == 2) {
                    System.out.println("continue");
                    continue;
                }
                if (i == 3) {
                    System.out.println("break");
                    i++;
                    break;
                }
                if (i == 7) {
                    System.out.println("continue outer");
                    i++;
                    //跳到outer标记的循环外，会在进入
                    continue outer;
                }
                if (i == 8) {
                    //跳到outer标记的循环外，不会在进入
                    System.out.println("break outer");
                    break outer;
                }
                for (int k = 0; k < 5; k++) {
                    if (k == 3) {
                        //跳到inner标记的循环外，continue inner的i会继续递增
                        //跳到inner标记的循环外，break inner的i会变回初始值
                        System.out.println("continue inner");
                        continue inner;
                    }
                }
            }
        }
    }

    @Test
    public void test5() {
        Random random = new Random(47);
        for (int i = 0; i < 100; i++) {
            //random.nextInt会产生0-26之间的一个值，加上a则产生的都是小写字母
            int c = random.nextInt(26) + 'a';
            System.out.print((char) c + "," + c + ":");
            //如果case中没有加上break;会直接执行下一行的case
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    System.out.println("vowel");
                    break;
                case 'y':
                case 'w':
                    System.out.println("Sometimes a vowel");
                    break;
                default:
                    System.out.println("consonant");
            }
        }
    }

    @Test
    public void test6() {
        int p = 1;
        int c = 1;
        int n;
        for (int i = 1; i <= 10; i++) {
            if (i <= 2) {
                System.out.print(1 + " ");
            } else {
                n = p + c;
                p = c;
                c = n;
                System.out.print(n + " ");
            }
        }
    }

    @Test
    public void test7() {
        int sum = 0;
        int[] startDigit = new int[4];
        int[] productDigit = new int[4];
        for (int num1 = 10; num1 <= 99; num1++)
            for (int num2 = num1; num2 <= 99; num2++) {
                int product = num1 * num2;
                /*
                   product - num1 - num2解释:
                     吸血鬼算法本质是:num1*num2=product
                     且num1和num2的数字组合为product中的
                     如:80*86=6880 80 86 都为6880里的数字
                     则:product=1000a+100b+10c+d
                        num1=10a+b num2=10c+d
                     顺序不一致没事
                     product - num1 - num2
                     =1000a+100b+10c+d-10a-b-10c-d
                     =990a+99b+9c
                     =9*(110a+11b+c)%9 ==0
                     可以进一步的筛选出吸血鬼数字
                 */
                if (product % 100 == 0 || (product - num1 - num2) % 9 != 0) {
                    continue;
                }
                startDigit[0] = num1 / 10;
                startDigit[1] = num1 % 10;
                startDigit[2] = num2 / 10;
                startDigit[3] = num2 % 10;
                productDigit[0] = product / 1000;
                productDigit[1] = (product % 1000) / 100;
                productDigit[2] = product % 1000 % 100 / 10;
                productDigit[3] = product % 1000 % 100 % 10;
                int count = 0;
                for (int x = 0; x < 4; x++)
                    for (int y = 0; y < 4; y++) {
                        if (productDigit[x] == startDigit[y]) {
                            count++;
                            productDigit[x] = -1;
                            startDigit[y] = -2;
                            if (count == 4) {
                                System.out.println(num1 + "*" + num2 + "=" + product);
                                sum++;
                            }
                        }
                    }
            }
        System.out.println("方法1共找到" + sum + "组吸血鬼数");
    }
}