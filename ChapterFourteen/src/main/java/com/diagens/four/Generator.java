package com.diagens.four;

/**
 * @author ZNJ
 * @create 2019-02-27 14:58
 */
public class Generator<T>{
    private Class<T> type;

    public Generator(Class<T> type) {
        this.type = type;
    }

    public T next() throws IllegalAccessException, InstantiationException {
        return type.newInstance();
    }
}
