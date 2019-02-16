package com.diagens.three;

import java.security.Policy;

/**
 * @author ZNJ
 * @create 2019/2/15-21:47
 */
public class Demo {
    public static void main(String[] args) {
        //预期打印10，当PolyConstructors初始化时i没有被加载，所以为0
        PolyConstructors pc=new PolyConstructors();
    }
}
