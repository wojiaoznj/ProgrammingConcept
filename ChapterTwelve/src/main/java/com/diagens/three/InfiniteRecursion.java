package com.diagens.three;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZNJ
 * @create 2019/2/24-20:40
 */
public class InfiniteRecursion {
    //打印内存地址
    //当想打印出对象的内存地址时，不该使用this，InfiniteRecursion address
    //后面有一个+,而后面的不是toString,编译器将尝试this转换为一个String,
    //通过调用this上的toString方法，于是发生了递归调用。
    //如果需要查看对象的内存地址使用super.toString
    public String toString(){
        //return "InfiniteRecursion address"+this+"\n";
        return "InfiniteRecursion address"+super.toString()+"\n";
    }

    public static void main(String[] args) {
        List<InfiniteRecursion> list=new ArrayList<>();
        for (int i=0;i<10;i++){
           list.add(new InfiniteRecursion());
        }
        System.out.println(list);
    }
}
