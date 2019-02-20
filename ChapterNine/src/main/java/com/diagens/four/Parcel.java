package com.diagens.four;

/**
 * @author ZNJ
 * @create 2019/2/19-23:10
 */
public class Parcel {
    private String name;

    private void printStr(){
        System.out.println("Hello,World");
        System.out.println(name);
    }

    public void useInner(){
        new PDestination().name="ZNJ"; //可以调用内部类的private元素
        new PDestination().readLabel();
    }

    protected class PDestination implements Destination{
        private String name;
        public String readLabel() {
            Parcel parcel=new Parcel();
            parcel.name="Hello,World";
            parcel.printStr();
            return "YuanXiaoKuaiLe";
        }
    }

    public static void main(String[] args) {
       Parcel parcel=new Parcel();
       parcel.useInner();
    }
}
