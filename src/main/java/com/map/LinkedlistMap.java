package com.map;


import com.set.FileOperation;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: fanbopeng
 * @Date: 2019/1/3 20:41
 * @Description:
 */
public class LinkedlistMap<K, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;

        }

        public Node(K key) {
            this(key, null, null);

        }

        public Node() {
            this(null, null, null);

        }


        @Override
        public String toString() {

            return key.toString() + value.toString();

        }

    }

    private Node dummyHead;
    private int size;

    private Node getNode(K key) {
        Node curNode = dummyHead.next;
        while (curNode.next != null) {
            if (curNode.key == key) {

                return curNode;
            } else {

                curNode = curNode.next;
            }
        }
        return null;
    }


    public LinkedlistMap() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;

        } else {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }

    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(key)) {
                break;

            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        if (getNode(key) != null) {

            return true;
        } else {

            return false;
        }


    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        if (node == null) {

            throw new IllegalArgumentException("没有这个节点");
        } else {

            return node.value;
        }


    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node != null) {
            node.value = newValue;

        } else {
            dummyHead.next = new Node(key, newValue, dummyHead.next);
            size++;
        }

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {

        ArrayList<String> words=new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)){
            System.out.println(words.size());

        }
        LinkedlistMap<String,Integer> map=new LinkedlistMap<>();
        for (String word :words){
            if (map.contains(word)){

                map.set(word, map.get(word)+1);
            }else {
                map.add(word, 1);

            }
            System.out.println("123");
            System.out.println(map.getSize());
            System.out.println(map.get("pride"));
        }
    }
}
