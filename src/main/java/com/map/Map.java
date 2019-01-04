package com.map;

/**
 * @author: fanbopeng
 * @Date: 2019/1/3 20:38
 * @Description:
 */
public interface Map<K,V> {

    void  add(K key,V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key,V newValue);
    int getSize();
    boolean isEmpty();


}
