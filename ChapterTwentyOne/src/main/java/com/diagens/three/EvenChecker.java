package com.diagens.three;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZNJ
 * @create 2019-03-25 16:42
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even!");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press Control-C to exit");
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            service.execute(new EvenChecker(gp, i));
        }
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
