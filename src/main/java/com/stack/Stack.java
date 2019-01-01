package com.stack;

/**
 * @author: fanbopeng
 * @Date: 2018/12/31 22:08
 * @Description:
 */
public interface Stack<E> {


    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();




}
