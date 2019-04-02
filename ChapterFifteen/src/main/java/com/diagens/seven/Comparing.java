package com.diagens.seven;

import java.util.Arrays;

/**
 * @author ZNJ
 * @create 2019-03-05 17:07
 */
public class Comparing {
    public int[] ints;

    public Comparing(int size) {
        ints=new int[size];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comparing comparing = (Comparing) o;
        return Arrays.equals(ints, comparing.ints);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(ints);
    }
}
