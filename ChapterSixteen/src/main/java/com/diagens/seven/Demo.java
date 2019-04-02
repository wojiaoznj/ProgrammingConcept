package com.diagens.seven;

import org.junit.Test;

import java.util.*;

/**
 * @author ZNJ
 * @create 2019-03-06 13:32
 */
public class Demo {
    @Test
    public void test1(){
        List<Integer> list=new ArrayList<Integer>();
        List<Integer> list1=new LinkedList<Integer>();

        list=com.diagens.two.Demo.genator(list);
        list1=com.diagens.two.Demo.genator(list1);

        Iterator it=list.iterator();
        while (it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();
        Iterator it1=list1.iterator();
        while (it1.hasNext()){
            System.out.print(it1.next()+" ");
        }
        System.out.println();
        ListIterator li=list.listIterator(list.size());

        while (li.hasPrevious()){
            li.add(list1.get(li.previousIndex()));
            li.previous();
            li.previous();
        }

        it1=list.iterator();
        while (it1.hasNext()){
            System.out.print(it1.next()+" ");
        }
    }
}
