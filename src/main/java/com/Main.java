package com;

import com.array.MyArray;

/**
 * @author: fanbopeng
 * @Date: 2018/12/31 10:45
 * @Description:
 */
public class Main {


    public static void main(String[] args) {

        MyArray<Integer> array = new MyArray(20);
        for (int i=0;i<10;i++){

            array.addList(i);

        }


        System.out.println(array.toString());
        System.out.println(array.toStringArrays());
        System.out.println(array.contains(12));
        System.out.println(array.findIndex(9));
    }

}
