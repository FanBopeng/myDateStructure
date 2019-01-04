package com.set;

import com.link.LinkedList;

/**
 * @author: fanbopeng
 * @Date: 2019/1/3 19:34
 * @Description:
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> linkedListSet;

    public LinkedListSet() {

        linkedListSet =new LinkedList<>();
    }

    @Override
    public void add(E e) {
           if (!linkedListSet.contains(e)){

               linkedListSet.addFirst(e);

           }
    }

    @Override
    public void remove(E e) {
        linkedListSet.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return linkedListSet.contains(e);
    }

    @Override
    public int getSize() {
        return linkedListSet.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedListSet.isEmpty();
    }
}
