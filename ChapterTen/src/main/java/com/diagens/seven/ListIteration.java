package com.diagens.seven;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author ZNJ
 * @create 2019-02-22 9:24
 */
public class ListIteration {
    public static void main(String [] args){
        List<Integer> list1=new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        //
        List<Integer> list2=new ArrayList<Integer>(list1.size());

        //从第几个索引开始遍历
        ListIterator<Integer> it=list1.listIterator(list1.size());

        //判断是否前一个还有元素
        while (it.hasPrevious()){
            //获取前一个元素
            list2.add(it.previous());
        }
        System.out.println(list2);
    }
}
