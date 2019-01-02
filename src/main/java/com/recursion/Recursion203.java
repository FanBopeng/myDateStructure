package com.recursion;

/**
 * @author: fanbopeng
 * @Date: 2019/1/2 10:53
 * @Description:删除链表中等于给定值 val 的所有节点
 */
public class Recursion203 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //无虚拟头结点方案
    public ListNode removeElements(ListNode head,int val){

        while (head!=null&&head.val==val){

            ListNode delNode=head;
            head=head.next;
            delNode.next=null;


        }
        if (head==null){

            return head;
        }
        ListNode    prevNode=head;
        while (prevNode.next!=null){
            if (prevNode.next.val==val) {
                ListNode delNode=prevNode.next;
                prevNode.next = delNode.next;
                delNode.next=null;

            }else {

                prevNode=prevNode.next;
            }

        }

        return head;

    }
    //有虚拟头节点方案
    public ListNode removeElements2(ListNode head,int val){

        ListNode dummyHead=new ListNode(-1);
        dummyHead.next=head;


        ListNode    prevNode=dummyHead;
        while (prevNode.next!=null){
            if (prevNode.next.val==val) {
                ListNode delNode=prevNode.next;
                prevNode.next = delNode.next;
                delNode.next=null;

            }else {

                prevNode=prevNode.next;
            }

        }

        return dummyHead.next;


    }

}
