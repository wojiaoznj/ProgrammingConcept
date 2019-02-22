package com.diagens.nine;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author ZNJ
 * @create 2019-02-22 14:52
 */
public class Demo {
    public static void main(String[] args) {
        Set set= new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);

        Set set1= new HashSet();
        set1.add(1);
        set1.add(2);
        System.out.println(set.contains(set1));    //true
        System.out.println(set.containsAll(set1)); //false

        String str = "+U+n+c---+e+r+t---+a-+i-+n+t+y---+r+u--+l+e+s---";
        String[] strs=str.split("");

        Stack<String> stack=new Stack<String>();

        for (int i=0;i<strs.length;i++) {
            if ("+".equals(strs[i])) {
               int k=i+1;
               stack.push(strs[k]);
            }else if("-".equals(strs[i])){
                System.out.println(stack.pop());
            }
        }
    }
}
