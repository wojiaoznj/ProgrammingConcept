package com.diagens.six;

/**
 * @author ZNJ
 * @create 2019-02-20 10:17
 */
public class ParcelSix {
    //匿名内部类，使用外部类的方法参数时，参数必须为final
    public Base pdase(final String name){
        return new Base(name){
            public void printStr(){
                System.out.println(name);
            }
        };
    }
}
