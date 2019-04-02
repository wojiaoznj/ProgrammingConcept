package com.diagens.nine;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author ZNJ
 * @create 2019-03-07 11:24
 */
public class Demo {
    @Test
    public void test1(){
        SlowMap<String,String> sm=new SlowMap<String, String>();
        sm.put("ppp","www");
        sm.put("ppp","www");
        sm.put("pp1","www");
        System.out.println(sm);
        System.out.println(sm.get("ppp"));
        System.out.println(sm.entrySet());
    }

    @Test
    public void test2(){
        SlowSet slowSet=new SlowSet();
        slowSet.add(1);
        slowSet.add(1);
        slowSet.add(2);
        slowSet.add(3);
        slowSet.add(1);
        Iterator iterator=slowSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
