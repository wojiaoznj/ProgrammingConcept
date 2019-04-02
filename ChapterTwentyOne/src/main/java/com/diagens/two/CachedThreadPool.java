package com.diagens.two;

import com.diagens.one.Liftoff;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZNJ
 * @create 2019-03-22 18:30
 */
public class CachedThreadPool {
    public static void main(String [] args){
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            pool.execute(new Liftoff());
        }
        pool.shutdown();
    }
}
