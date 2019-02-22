package com.diagens.eleven;

import java.util.Queue;

/**
 * @author ZNJ
 * @create 2019-02-22 16:26
 */
public class Command3 {
    public void use() {
        Command2 command2 = new Command2();
        Queue<Command> queue = command2.fill();
        while (queue.peek()!=null){
           queue.poll().operation();
        }
        System.out.println(queue);
    }

    public static void main(String[] args) {
        Command3 command3 = new Command3();
        command3.use();
    }
}
