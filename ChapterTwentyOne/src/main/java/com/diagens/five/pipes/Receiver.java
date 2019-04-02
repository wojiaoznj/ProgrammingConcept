package com.diagens.five.pipes;

import java.io.IOException;
import java.io.PipedReader;

/**
 * @author ZNJ
 * @create 2019-03-29 11:22
 */
public class Receiver implements Runnable {
    private PipedReader in;

    public Receiver(Sender sender) throws IOException {
        in=new PipedReader(sender.getPipedWriter());
    }

    public void run() {
        try {
            while (true){
                System.out.println("Read:"+(char)in.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
