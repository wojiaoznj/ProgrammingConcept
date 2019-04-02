package com.diagens.two.join;

/**
 * @author ZNJ
 * @create 2019-03-25 13:12
 */
public class Demo {
    public static void main(String [] args){
        Sleeper
             sleeper=new Sleeper("Sleeper",1500),
             grumpy=new Sleeper("Grumpy",1500);
        Joiner
             dopey=new Joiner("Dopey",sleeper),
             doc=new Joiner("Doc",grumpy);
        //中断指定线程
        grumpy.interrupt();
    }
}
