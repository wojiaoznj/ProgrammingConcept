package com.diagens.five.pipes;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-29 11:24
 */
public class PipedIO {
    public static void main(String [] args) throws IOException, InterruptedException {
        Sender sender=new Sender();
        Receiver receiver=new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}
