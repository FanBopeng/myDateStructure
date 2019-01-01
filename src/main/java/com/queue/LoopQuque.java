package com.queue;

/**
 * @author: fanbopeng
 * @Date: 2019/1/1 16:02
 * @Description:
 */
public class LoopQuque<E>  implements  Queue<E> {

    private  E[] data;
    private  int front,tail;
    private  int size;

    public LoopQuque(int capacity){

        //因为会浪费一个空间来维护队尾和队首指针不会重叠,所以在初始化的时候对capacity+1
        data= (E[]) new Object[capacity+1];
        front =0;
        tail=0;
        size=0;


    }

    public LoopQuque(){

       this(10);


    }

    public int getCapacity(){

        return  data.length-1;
    }

    @Override
    public void enqueue(E e) {
        if ((tail+1)%data.length==front){
            resize(getCapacity()*2);

        }
        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;

    }

    private void resize(int newCapacity) {

        E[] newData= (E[]) new Object[newCapacity+1];
        for (int i=0;i<size;i++){
            //
            newData[i]=data[(i+front)%data.length];

        }
        data=newData;
        front=0;
        tail=size;

    }

    @Override
    public E dequeue() {
        if (data==null){

            throw new IllegalArgumentException("空队列你咋拿值");
        }
        E ret=data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        //缩容
        if (size==getCapacity()/4&&getCapacity()/2!=0){

            resize(getCapacity()/2);

        }
        return ret;
    }

    @Override
    public E getFront() {




        return  data[front];
    }

    @Override
    public int getSize() {



        return size;
    }

    @Override
    public boolean isEmpty() {
        return front==tail;
    }
    @Override
    public String toString(){


        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size= %d,capacity= %d\n", size, getCapacity()));
        res.append("front[");
        for (int i = front; i!=tail; i=(i+1)%data.length) {
            res.append(data[i]);
            if ((i+1)%data.length!=tail) {
                res.append('.');

            }


        }
        res.append(" ] tail ");

        return res.toString();


    }

    public static void main(String[] args) {

        LoopQuque<Integer> loopQuque=new LoopQuque<>(10);
        for (int i=0;i<10;i++){

            loopQuque.enqueue(i);
            if (i%3==2){

                Integer dequeue = loopQuque.dequeue();

                System.out.println(dequeue);

            }
            System.out.println(loopQuque.toString());

        }

    }


}
