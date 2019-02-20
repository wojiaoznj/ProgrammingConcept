package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019-02-19 17:45
 */
public class Demo {
    public static void main(String [] args){
      Outer outer=new Outer();
      //利用一个外部类创建一个内部类
      Outer.Inner inner=outer.new Inner();
      inner.printStr("HelloWorld");

      //使用内部类创建一个外部类
      Outer outer1=inner.outer();
      outer1.printInt(123);
    }
}
