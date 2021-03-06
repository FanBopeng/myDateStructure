package com.link;

/**
 * @author: fanbopeng
 * @Date: 2019/1/1 20:15
 * @Description:
 */
public class LinkedList<E> {

    private class Node {

        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;

        }

        public Node(E e) {
            this(e, null);

        }

        public Node() {
            this(null, null);

        }


        @Override
        public String toString() {

            return e.toString();

        }

    }

    private Node dummyHead;
    private int size;

    public LinkedList() {

        dummyHead = new Node();
        size = 0;

    }


    public int getSize() {

        return size;
    }


    public boolean isEmpty() {


        return size == 0;
    }

    //在表头添加新的元素
    public void addFirst(E e) {
/*
        Node node= new Node(e);
        node.next=head;
        head=node;

        head = new Node(e, head);*/

        add(0,e );
        size++;


    }

    public void add(int index, E e) {
        if (index < 0 || index > size) {

            throw new IllegalArgumentException("位置错误");

        }


        Node prev = dummyHead;
        for (int i = 0; i < index ; i++) {
            prev = prev.next;

        }
          /*  Node node=new Node(e);
            node.next=prev.next;
            prev.next=node;*/

        prev.next = new Node(e, prev.next);

        size++;


    }


    public void addLast(E e) {
        add(size, e);


    }


    public E get(int index){
        if (index < 0 || index >= size) {

            throw new IllegalArgumentException("位置错误");

        }
        Node cur=dummyHead.next;
        for (int i=0;i<index;i++){

             cur=cur.next;

        }

        return cur.e;

    }

    public E getFirst(){

        return   get(0);

    }
    public E getLast(){

        return   get(size-1);

    }

    public  void set(int index,E e){
        if (index < 0 || index >= size) {

            throw new IllegalArgumentException("位置错误");

        }
        Node cur=dummyHead.next;
        for (int i=0;i<index;i++){

            cur=cur.next;

        }
            cur.e=e;

    }
    public boolean contains(E e){

        Node cur=dummyHead.next;
        for (int i=0;i<size;i++){
                if (cur.e==e){

                    return true;
                }

            cur=cur.next;

        }


        return false;
    }


    public E remove(int index){
        if (index < 0 || index >= size) {

            throw new IllegalArgumentException("位置错误");

        }
        Node prev=dummyHead;
        for (int i=0;i<index;i++){

        prev=prev.next;

        }
        Node retNode=prev.next;

        prev.next=retNode.next;
        retNode.next=null;
        size--;
        return retNode.e;

    }
    public E removeFirst(){


        return remove(0);
    }
    public E removeLast(){


        return remove(size-1);
    }



    @Override
    public  String toString(){

        StringBuilder res=new StringBuilder();

        Node cur=dummyHead.next;
        while (cur!=null){

            res.append(cur.e+"->");
            cur=cur.next;
        }
            res.append("null");

        return res.toString();
    }




    public static void main(String[] args) {

        LinkedList<Integer> linkedList=new LinkedList<>();
         for (int i=0;i<5;i++){

             linkedList.addFirst(i);
             System.out.println(linkedList.toString());
         }



    }


}
