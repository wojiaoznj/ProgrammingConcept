package com.diagens.eleven;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ZNJ
 * @create 2019-02-22 16:23
 */
public class Command2 {
    public Queue<Command> fill(){
        Queue<Command> queue=new LinkedList<Command>();
        for(int i=0;i<10;i++){
            queue.offer(new Command("三毛"+i));
        }

        return queue;
    }
}
