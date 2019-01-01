package com;

import com.array.MyArray;
import com.queue.ArrayQueue;
import com.queue.LoopQuque;
import com.queue.Queue;

import java.util.Random;

/**
 * @author: fanbopeng
 * @Date: 2018/12/31 10:45
 * @Description:
 */
public class Main {

    private static double testQueue(Queue<Integer> queue,int opCount){

        long start = System.nanoTime();

        Random random=new Random();


        for (int i=0;i<opCount;i++){

            queue.enqueue(random.nextInt(Integer.MAX_VALUE));

        }
        for (int i=0;i<opCount;i++){

            queue.dequeue();
        }



        long end=System.nanoTime();

        return (end-start)/1000000000.0;
    }




    public static void main(String[] args) {

       int opCount=100000;

       Queue<Integer> arrayQueue=new ArrayQueue<>(100000);
        System.out.println(testQueue(arrayQueue, opCount));
        Queue<Integer> loopQuque=new LoopQuque<>(100000);
        System.out.println(testQueue(loopQuque, opCount));

    }
}