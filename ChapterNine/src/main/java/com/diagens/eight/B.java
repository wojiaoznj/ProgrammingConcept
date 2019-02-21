package com.diagens.eight;

/**
 * @author ZNJ
 * @create 2019-02-20 20:14
 */
public class B {
    public U [] ub=new U[10];
    public int count=0;

    public void B1(U u){
        ub[count++]=u;
    }

    public void B2(){
        for(int i=0;i<count;i++){
            ub[i]=null;
        }
    }

    public void B3(){
        for(int i=0;i<count;i++){
            ub[i].u1();
            ub[i].u2();
            ub[i].u3();
        }
    }
}
