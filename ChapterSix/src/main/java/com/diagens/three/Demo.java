package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019-02-14 17:24
 */
public class Demo {
    private int i=printInt();

    private int printInt() {
        System.out.println(111);
        return 0;
    }

    public static void main(String[] args) {
        C c = new C("ss");
        //静态方法创建类，不会加载成员变量
        int i1=C.i1;
        int i2=C.i1;
        int i3=C.i1;
    }
}
