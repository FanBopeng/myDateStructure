package com.array;


import java.util.Arrays;

/**
 * @author: fanbopeng
 * @Date: 2018/12/31 09:58
 * @Description:
 */
public class MyArray<E> {

    private E[] data;
    private int size;

    //传入数组 的容量capacity构造数组
    public MyArray(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public MyArray() {

        this(10);
    }


    //获取元素个数
    public int getSize() {

        return size;

    }

    //获取数组容量
    public int getCapacity() {

        return data.length;

    }

    public boolean isEmpty() {


        return size == 0;
    }

    //向数组中添加一个元素
    public void addList(E e) {

        add(size, e);


    }

    //向数组头节点添加一个元素
    public void addFirst(E e) {

        add(0, e);
    }

    //指定 index位置插入元素
    public void add(int index, E e) {
        if (size == data.length) {

           resize(2*data.length);
        }

        if (index < 0 || index > size) {

            throw new IllegalArgumentException("下标非法");
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;


        size++;

    }

    private void resize(int newCapacity) {

        E[] newData= (E[]) new Object[newCapacity];
        for (int i=0;i<size;i++){
            newData[i]=data[i];

        }
        data=newData;


    }


    public String toStringArrays() {
        return "MyArray{" +
                "date=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size= %d,capacity= %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append('.');

            }


        }
        res.append(']');

        return res.toString();
    }

    //获取索引位置的元素
    public E get(int index) {

        if (index < 0 || index > size) {

            throw new IllegalArgumentException("index位置错误");
        }
        return data[index];
    }

    public void set(int index, E e) {

        if (index < 0 || index > size) {

            throw new IllegalArgumentException("index位置错误");
        }

        data[index] = e;

    }

    //查找数组中是否存在这个数字
    public boolean contains(E e) {

        int low = 0;
        int high = data.length - 1;
        int middle = 0;

        while (low <= high) {

            middle = (low + high) / 2;

            if (data[middle].equals(e)) {

                high = high - 1;

            } else if (data[middle] .equals(e)) {
                low = low + 1;

            } else {

                return true;

            }


        }

        return false;

    }

    public int findIndex(E e) {
        int low = 0;
        int high = data.length - 1;
        int middle = 0;

        while (low <= high) {

            middle = (low + high) / 2;

            if (data[middle].equals(e)) {

                high = high - 1;

            } else if (data[middle].equals(e)) {
                low = low + 1;

            } else {

                return middle;

            }


        }
        return -1;

    }
    //删除index位置的元素,并且返回删除的元素
    public E remove(int index) {
        if (index<0||index >size){
            throw  new IllegalArgumentException("index错误");

        }
        E ret=data[index];

        for (int i =  index+1; i < size; i++) {

            data[i-1]=data[i];

        }

        size--;
        data[size]=null;

        if (size==data.length/2){

            resize(data.length/2);

        }
        return ret;
    }

    public E removeFirst(){

       return remove(0);
    }


    public E removeLast(){

        return remove(size-1);
    }

    public void removeElement(E e){

        int index = findIndex(e);
        if (index !=-1){

            remove(index);
        }
    }

    public E getLast(){

           return get(size-1);


    }
    public E getFirst(){

        return  get(0);

    }

}
