package com.queue;

import com.array.MyArray;
import com.queue.Queue;

import javax.swing.*;

/**
 * @author: fanbopeng
 * @Date: 2019/1/1 14:45
 * @Description:
 */
public class ArrayQueue<E> implements Queue<E> {


    private MyArray<E> array;

    public  ArrayQueue(int capacity){

        array=new MyArray<E>(capacity);

    }



    @Override
    public void enqueue(E e) {

        array.addList(e);

    }

    @Override
    public E dequeue() {

     return    array.removeFirst();

    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){

       return   array.getCapacity();

    }
    @Override
    public  String toString(){
        StringBuilder res = new StringBuilder();
        res.append("queue");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append('.');

            }


        }
        res.append("] tail");

        return res.toString();


    }

    public static void main(String[] args) {

        ArrayQueue<Integer> arrayQueue=new ArrayQueue<>(10);
        for (int i=0;i<10;i++){

            arrayQueue.enqueue(i);

        }

        System.out.println(arrayQueue.toString());

    }



}
