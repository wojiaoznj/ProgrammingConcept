package com.diagens.eight;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author ZNJ
 * @create 2019-03-06 19:41
 */
public class Demo{
    @Test
    public void test1(){
        LinkedHashMap<Integer,String> linkedHashMap=new LinkedHashMap<Integer, String>();
        linkedHashMap= (LinkedHashMap<Integer, String>) padding(linkedHashMap);
        System.out.println(linkedHashMap);

        //初始容量为16，扩增策略为16*0.75,
        //accessOrder false 基于插入顺序 true 基于访问顺序（get一个元素后，这个元素被加到最后，使用了LRU 最近最少被使用的调度算法）
        linkedHashMap=new LinkedHashMap<Integer, String>(16,0.75f,true);
        linkedHashMap= (LinkedHashMap<Integer, String>) padding(linkedHashMap);
        System.out.println(linkedHashMap);
        for(int i=0;i<6;i++){
           linkedHashMap.get(i);
        }
        System.out.println(linkedHashMap);
        linkedHashMap.get(0);
        System.out.println(linkedHashMap);
    }

    public static Map<Integer,String> padding(Map<Integer,String> map){
        for(int i=0;i<9;i++){
          map.put(i,""+i);
        }
        return map;
    }
}
