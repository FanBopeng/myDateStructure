package com.set;

/**
 * @author: fanbopeng
 * @Date: 2019/1/3 19:06
 * @Description:
 */
public interface Set<E> {

    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
