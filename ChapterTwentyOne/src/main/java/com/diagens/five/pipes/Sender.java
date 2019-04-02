package com.diagens.five.pipes;

import java.io.IOException;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author ZNJ
 * @create 2019-03-29 11:09
 */
public class Sender implements Runnable {
    private Random random=new Random(47);
    private PipedWriter out=new PipedWriter();
    public PipedWriter getPipedWriter(){return  out;}

    public void run() {
       try {
           while (true){
               for(char c='A';c<='z';c++){
                   out.write(c);
                   TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
    }
}
