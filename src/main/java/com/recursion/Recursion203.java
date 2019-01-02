package com.recursion;



/**
 * @author: fanbopeng
 * @Date: 2019/1/2 10:53
 * @Description:删除链表中等于给定值 val 的所有节点
 */
public class Recursion203 {


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

    //递归方式
    public static ListNode removeElementsTest(ListNode head,int val,int depth/*递归深度*/){
        String depthString=generaDepthString(depth);
        System.out.println(depthString);
        System.out.println("Call:remove "+val+"in "+head);
        if (head==null){
            System.out.print(depthString);
            System.out.println("return:" +head);
            return head;
        }

        ListNode res = removeElementsTest(head.next, val, depth + 1);
        System.out.println(depthString);
        System.out.println("After Remove "+val+":"+res);

        ListNode  ret;
        if (head.val==val){
            ret=res;
        }else {
            head.next=res;
            ret=head;

        }
        System.out.println(depthString);
        System.out.println("return: "+ret);
        return ret;


    }
    public static ListNode removeElements3(ListNode head,int val){
        if (head==null){
            return head;

        }
       head.next=  removeElements3(head.next, val);

        return head.val==val? head.next:head;

    }

    private static String generaDepthString(int depth) {

        StringBuilder res=new StringBuilder();
        for (int i=0;i<depth;i++){
            res.append("--");

        }
        return res.toString();
    }


    public static void main(String[] args) {

    int[] nums={1,2,3,4,5};
    ListNode head=new ListNode(nums);
        System.out.println(removeElements3(head,5 ));
    }

}
