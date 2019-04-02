package com.diagens.seven;

import java.util.Arrays;

/**
 * @author ZNJ
 * @create 2019-03-05 16:41
 */
public class CopyingArrays {
    public static void main(String[] args) {
        int[] i = new int[7];
        int[] j = new int[10];

        //将一个数组全部填充一个值
        Arrays.fill(i, 47);
        Arrays.fill(j, 99);
        System.out.println("i=" + Arrays.toString(i));
        System.out.println("j=" + Arrays.toString(j));
        //arraycope参数:原数组，表示从原数组中的什么位置开始复制的偏移量
        //目标数组，表示从目标数组什么位置开始复制的偏移量，以及需要复制的元素个数
        System.arraycopy(i, 0, j, 0, i.length);
        System.out.println("j=" + Arrays.toString(j));
        int[] k = new int[5];
        Arrays.fill(k,103);
        System.arraycopy(k,0,i,0,k.length);
        System.out.println("i="+Arrays.toString(i));

        Integer[] u=new Integer[10];
        Integer[] v=new Integer[5];
        Arrays.fill(u,new Integer(47));
        Arrays.fill(v,new Integer(99));
        System.out.println("u="+Arrays.toString(u));
        System.out.println("v="+Arrays.toString(v));

        System.arraycopy(v,0,u,u.length/2,v.length);
        System.out.println("u="+Arrays.toString(u));
    }
}
