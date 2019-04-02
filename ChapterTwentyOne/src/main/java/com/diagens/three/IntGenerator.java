package com.diagens.three;

/**
 * @author ZNJ
 * @create 2019-03-25 16:39
 */
public abstract class IntGenerator {
    private volatile boolean canceled=false;
    public abstract int next();
    public void cancel(){
        canceled=true;
    }
    public boolean isCanceled(){
        return canceled;
    }
}
