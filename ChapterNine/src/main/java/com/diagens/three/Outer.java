package com.diagens.three;

import java.util.Date;

/**
 * @author ZNJ
 * @create 2019-02-19 17:42
 */
public class Outer {
    class Inner{
        public void printStr(String str){
            System.out.println(str);
        }

        public Outer outer(){
            return Outer.this;
        }
    }

    public void printInt(int i){
        System.out.println(i+" "+new Date());
    }
}
