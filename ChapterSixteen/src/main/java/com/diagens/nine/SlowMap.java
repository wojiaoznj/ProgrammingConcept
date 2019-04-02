package com.diagens.nine;

import java.util.*;

/**
 * @author ZNJ
 * @create 2019-03-07 11:13
 */
public class  SlowMap<K,V> extends AbstractMap<K,V> {
    private List<K> keys=new ArrayList<K>();
    private List<V> values=new ArrayList<V>();

    public V put(K key, V value){
        int index=keys.indexOf(key);
        if(index<0){
          keys.add(key);
          values.add(value);
        }else{
          values.set(index,value);
        }
        return value;
    }

    public V get(Object key){
        if(!keys.contains(key)){
            return null;
        }
        return values.get(keys.indexOf(key));
    }

   public static class MapEntry<K,V> implements Map.Entry{
        private K keys;
        private V values;

        public MapEntry() {

        }

        public MapEntry(K keys, V values) {
            this.keys = keys;
            this.values = values;
        }

        public Object getKey() {
            return keys;
        }

        public Object getValue() {
            return values;
        }

        public Object setValue(Object value) {
            V result=values;
            values= (V) value;
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MapEntry<?, ?> mapEntry = (MapEntry<?, ?>) o;
            return Objects.equals(keys, mapEntry.keys) &&
                    Objects.equals(values, mapEntry.values);
        }

        @Override
        public int hashCode() {

            return Objects.hash(keys, values);
        }

        @Override
        public String toString() {
            return "MapEntry{" +
                    "keys=" + keys +
                    ", values=" + values +
                    '}';
        }
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> set=new HashSet<Entry<K, V>>();
        Iterator<K> ki=keys.iterator();
        Iterator<V> vi=values.iterator();
        while (ki.hasNext()){
            set.add(new MapEntry<K,V>(ki.next(),vi.next()));
        }
        return set;
    }
}
