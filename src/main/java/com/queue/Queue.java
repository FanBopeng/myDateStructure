package com.queue;

/**
 * @author: fanbopeng
 * @Date: 2019/1/1 14:43
 * @Description:
 */
public interface Queue<E> {

        void enqueue(E e);
        E    dequeue();
        E    getFront();
        int getSize();
        boolean isEmpty();



}
