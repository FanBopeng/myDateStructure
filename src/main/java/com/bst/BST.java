package com.bst;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Random;

/**
 * @author: fanbopeng
 * @Date: 2019/1/2 14:33
 * @Description:
 */
public class BST<E extends Comparable<E>> {

    private class Node {

        public Node right;
        public Node left;
        public E e;

        public Node(E e) {
            this.e = e;
            right = null;
            left = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {


        return size;
    }

    public boolean isEmpty() {

        return size == 0;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    public void add2(E e) {
        root = add2(root, e);


    }

    private void add(Node node, E e) {
        if (node.e == e) {

            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {

            node.left = new Node(e);
            size++;
            return;

        } else if (e.compareTo(node.e) > 0 && node.right == null) {

            node.right = new Node(e);
            size++;
            return;

        }
        if (e.compareTo(node.e) < 0) {

            add(node.left, e);

        } else {

            add(node.right, e);
        }
    }

    //向以Node为跟的二分搜索树中插入元素e,递归算法
    //返回插入新节点后二叉搜索树的跟
    private Node add2(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add2(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add2(node.right, e);
        }

        return node;
    }

    public boolean contains(E e) {

        return contains(root, e);

    }

    public boolean contains(Node node, E e) {
        if (node == null) {

            return false;
        }
        if (e.compareTo(node.e) == 0) {

            return true;
        } else if (e.compareTo(node.e) < 0) {

            return contains(node.left, e);
        } else {

            return contains(node.right, e);
        }

    }

    //前序遍历,以node为根
    public void preOrder() {

        preOrder(root);

    }

    private void preOrder(Node root) {
  /*      if (root==null){

            return;
        }
        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);

    }*/
        if (root != null) {
            System.out.println(root.e);
            preOrder(root.left);
            preOrder(root.right);

        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);

        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateBSTString(depth) + "null\n");
            return;
        }
        res.append(generateBSTString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateBSTString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {

            res.append("--");

        }
        return res.toString();

    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] a = {1, 2, 3, 2, 1, 2};

        for (int i = 0; i < a.length; i++) {
            bst.add(a[i]);
        }
        bst.preOrder();
        System.out.println(bst.toString());

    }


}
