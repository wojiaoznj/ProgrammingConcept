package com.diagens.three;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ZNJ
 * @create 2019-02-27 13:43
 */
public class Demo {
    List<Factory> factories = new ArrayList<Factory>();
    Class[] types = {Americano.class, Cappuccino.class, Latte.class, Mocha.class};

    Random random = new Random(47);

    {
        factories.add(new Americano.Factory());
        factories.add(new Cappuccino.Factory());
        factories.add(new Latte.Factory());
        factories.add(new Mocha.Factory());
    }

    @Test
    public void test1() {
        for (int i = 0; i < 10; i++) {
            int n = random.nextInt(factories.size());
            System.out.println(factories.get(n).create().toString());
        }
    }

    @Test
    public void test2() throws IllegalAccessException, InstantiationException {
        for (int i = 0; i < 10; i++) {
            int n = random.nextInt(factories.size());
            System.out.println(types[n].newInstance().toString());
        }
    }
}
