package com.diagens.three;

import org.junit.jupiter.api.Test;

/**
 * @author ZNJ
 * @create 2019-02-14 17:20
 */
public class C extends A {
    public B b;

    public C(String ss) {
        super(ss);
        b=new B(ss);
    }
}
