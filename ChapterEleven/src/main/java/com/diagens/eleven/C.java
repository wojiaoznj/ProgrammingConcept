package com.diagens.eleven;

/**
 * @author ZNJ
 * @create 2019/2/24-17:29
 */
public class C extends B {
    @Override
    public void findException() throws Exception {
        throw new SonException();
    }
}
