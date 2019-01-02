package com.stack;

import com.link.LinkedList;

/**
 * @author: fanbopeng
 * @Date: 2019/1/2 09:52
 * @Description:
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> linkedList;


    public LinkedListStack() {
        linkedList = new LinkedList<E>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {

        linkedList.addFirst(e);

    }

    @Override
    public E pop() {

        return linkedList.remove(0);
    }

    @Override
    public E peek() {
        return linkedList.get(0);
    }


    @Override
    public String toString() {


        StringBuilder res = new StringBuilder();
        res.append("stact: top ");
        res.append(linkedList);


        return res.toString();


    }


    public static void main(String[] args) {

        LinkedListStack<Integer> stack = new LinkedListStack();
        for (int i = 0; i < 20; i++) {


            stack.push(i);

            if (i % 3 == 2) {

                System.out.println(stack.pop());

            }

            System.out.println(stack.toString());

        }

    }
}
