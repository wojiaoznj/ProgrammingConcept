package com.diagens.two;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author ZNJ
 * @create 2019-03-22 19:02
 */
public class CallableDemo {
    static class TaskWithResult implements Callable<String>{
        private int id;

        public TaskWithResult(int id) {
            this.id = id;
        }

        public String call() throws Exception {
            return "result of TaskWithResult "+id;
        }
    }

    public static void main(String [] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results=new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            results.add(service.submit(new TaskWithResult(i)));
        }

        for (Future<String> result : results) {
            System.out.println(result.get());
        }
    }
}
