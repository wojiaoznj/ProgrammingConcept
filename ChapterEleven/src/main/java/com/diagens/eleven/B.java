package com.diagens.eleven;

/**
 * @author ZNJ
 * @create 2019/2/24-17:28
 */
public class B extends A {
    @Override
    public void findException() throws Exception {
        throw new BaseException();
    }
}
