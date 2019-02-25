package com.diagens;

import org.junit.jupiter.api.Test;

/**
 * @author ZNJ
 * @create 2019/2/25-22:50
 */
public class Demo {
    static void printInfo(Class cc) {
        //getName产生全限定的类名，isInstance是否是表示为接口
        System.out.println("Class name:" + cc.getName() + " is interface?" +
                "[" + cc.isInstance(cc)+ "]");
        //getSimpleName不包含包名的类名
        System.out.println("Simple name:"+cc.getSimpleName());
        //getCanonicalName产生全限定的类名
        System.out.println("Canonical name:"+cc.getCanonicalName());
    }

    @Test
    public void test1(){
        Class c=null;
        try{
           c=Class.forName("com.diagens.FancyToy");
        } catch(Exception e){
            System.out.println("Can't find FancyToy");
        }
        printInfo(c);
        //返回c类中包含的接口
        for (Class face:c.getInterfaces()){
           printInfo(face);
        }
        //返回c类的基类
        Class up=c.getSuperclass();
        Object obj=null;
        try{
            //实现虚拟构造器
           obj=up.newInstance();
        } catch(Exception e){
           e.printStackTrace();
        }
        printInfo(obj.getClass());
    }

    @Test
    public void test2(){
        char[] chr=new char[10];
        for (int i = 0; i < 10; i++) {
            chr[i]=(char)i;
        }
        char[] chr1=chr;
        System.out.println((int)chr[5]);
        chr1[5]=(char)26;
        System.out.println((int)chr1[5]);
        System.out.println((int)chr[5]);
    }

}
