package com.diagens.two;

import com.diagens.one.Liftoff;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZNJ
 * @create 2019-03-22 18:50
 */
public class SingleThreadExcutor {
    public static void main(String [] args){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Liftoff());
        }
        executorService.shutdown();
    }
}
