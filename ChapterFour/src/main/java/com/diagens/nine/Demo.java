package com.diagens.nine;

import org.junit.jupiter.api.Test;

/**
 * @author ZNJ
 * @create 2019/2/13-22:53
 */
public class Demo {
    @Test
    public void test1() {
        for (MoneyEnum me : MoneyEnum.values()) {
            System.out.println(me + ".ordinal " + me.ordinal());
        }
    }

    @Test
    public void test2() {
        for (MoneyEnum me : MoneyEnum.values()) {
            describe(me);
        }
    }

    private void describe(MoneyEnum moneyEnum) {
        System.out.println("This burrito is ");
        switch (moneyEnum) {
            case FUR:
                System.out.println("毛");
                break;
            case TEN:
                System.out.println("十");
                break;
            case CHUNK:
                System.out.println("块");
                break;
            case MINUTE:
                System.out.println("分");
                break;
            case HUNDRED:
                System.out.println("百");
                break;
            case THOUSAND:
                System.out.println("千");
                break;
        }
    }

}
