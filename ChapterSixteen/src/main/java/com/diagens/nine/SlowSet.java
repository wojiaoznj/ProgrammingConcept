package com.diagens.nine;

import java.util.*;

/**
 * @author ZNJ
 * @create 2019-03-07 11:32
 */
public class SlowSet<T> extends AbstractSet {
    private List<T> set=new ArrayList<>();

    @Override
    public boolean add(Object o) {
        try {
            if(!set.contains(o)){
                set.add((T) o);
            }else{
                set.set(set.indexOf(o), (T) o);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Iterator iterator() {
        return set.iterator();
    }

    @Override
    public int size() {
        return set.size();
    }
}
