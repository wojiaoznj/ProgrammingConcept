package com.diagens.ten;

import org.junit.Test;

import java.util.*;

/**
 * @author ZNJ
 * @create 2019-03-07 16:50
 */
public class Demo {
    @Test
    public void test1(){
        List list1=new ArrayList();
        List list2=new LinkedList();
        Random random=new Random();
        for(int i=0;i<1000;i++){
            list1.add(random.nextInt(1000));
            list2.add(random.nextInt(1000));
        }
        System.out.println(list1);
        System.out.println(list2);
        long time=System.nanoTime();
        Collections.sort(list1);
        long time1=System.nanoTime();
        System.out.println(time1-time);
        Collections.sort(list2);
        System.out.println(System.nanoTime()-time1);
        System.out.println(list1);
        System.out.println(list2);
    }

    @Test
    public void test2(){
        CustomArray ca=new CustomArray();
        List list=new ArrayList();
        Random random=new Random();
        long time=System.nanoTime();
        for(int i=0;i<1000;i++){
            ca.add(random.nextInt(1000)+"");
        }
        long time1=System.nanoTime();
        System.out.println(time1-time);
        System.out.println(Arrays.toString(ca.strings));
        for(int i=0;i<1000;i++){
            list.add(random.nextInt(1000)+"");
        }
        System.out.println(list);
        System.out.println(System.nanoTime()-time1);
    }

    @Test
    public void test3(){
        List list= Collections.synchronizedList(new ArrayList<>());
        Iterator iterator=list.iterator();
        list.add("dd");
        //ConcurrentModificationException
        iterator.next();
    }
}
