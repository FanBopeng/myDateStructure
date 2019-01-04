package com.map;



/**
 * @author: fanbopeng
 * @Date: 2019/1/4 11:38
 * @Description:
 */
public class BSTMap<K extends Comparable<K>  ,V> implements Map<K, V> {

    private class Node {

        public K key;
        public V value;
        public Node left;
        public Node right;

        public Node(K key,V value) {
            this.key = key;
            this.value = value;
            right = null;
            left = null;
        }
    }

    private Node root;
    private  int size;

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(K key, V value) {
        root= add(root,key,value );



    }

    private Node add( Node root,K key, V value) {
        if (root==null){
            size++;
            return new Node(key,value) ;

        }
        if (key.compareTo(root.key)<0){
           root.left= add(root.left,key,value );
        }else if (key.compareTo(root.key)>0){
            root.right= add(root.right,key,value );
        }else {
                root.value=value;

        }

            return root;

    }
    public Node getNode(Node node,K key){
        if (node==null){

            return null;
        }
        if (key.compareTo(node.key)<0){
            return  getNode(node.left, key);

        }else if (key.compareTo(node.key)>0)  {
            return   getNode(node.right, key);

        }else {

            return node;
        }

    }



    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node!=null){

         root =  remove(root,key);

         return root.value;
        }
        throw new IllegalArgumentException("mei you zhe ge key");

    }

    private Node remove(Node node, K key) {
        if (node==null){

            return null;
        }
        if (key.compareTo(node.key)<0){
            node.left=remove(node.left,key);
            return node;
        }else if (key.compareTo(node.key)>0){
            node.right=remove(node.right,key);
            return node;
        }else {
            //待删除节点左树为空
            if (node.left==null){
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;

            }
            //待删除节点右树为空
            if (node.right==null){
                Node leftNode=node.left;
                node.right=null;
                size--;
                return leftNode;

            }



        }

            return null;
    }


    private Node removeMin(Node node) {
        if (node.left==null){
            Node rightNode=node.right;
            node.right=null;
            size--;
            return rightNode;
        }
        node.left= removeMin(node.left);

        return node;

    }

    //寻找二分搜索树的最小元素
    public K minimum(){
        if (size==0){

            throw  new IllegalArgumentException("bst is empty");


        }
        return  minimum(root).key;


    }

    private Node minimum(Node node) {

        if (node.left==null){
            return node;

        }
        return minimum(node.left);
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key)!=null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        if (node!=null){

            return node.value;
        }

        throw new IllegalArgumentException("mei you zhe ge key");
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);

        if (node!=null){

           node.value=newValue;
        }
        throw new IllegalArgumentException("mei you zhe ge key");
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }
}
