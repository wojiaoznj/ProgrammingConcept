package com.diagens.one;

/**
 * @author ZNJ
 * @create 2019/2/18-23:22
 */
public class Outer {
    class Inner{
        private String label;
        public Inner(String whereTo){
            label=whereTo;
        }

        String readLable(){
            return label;
        }
    }

    public Inner toInner(String dest){
         return new Inner(dest);
    }
    
    public void ship(String dest){
        Inner inner=toInner(dest);
        System.out.println(inner.readLable());
    }
    
}
