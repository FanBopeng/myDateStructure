package com.recursion;

/**
 * @author: fanbopeng
 * @Date: 2019/1/2 12:32
 * @Description:
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int[] arr) {
        this.val=arr[0];
        ListNode cur=this;
        for (int i=1;i<arr.length;i++){
            cur.next=new ListNode(arr[i]);
            cur=cur.next;

        }
    }
    @Override
    public String toString() {
        StringBuilder res=new StringBuilder();
        ListNode cur=this;
        while (cur!=null){
            res.append(cur.val+"->");
            cur=cur.next;


        }
        res.append("null");
        return res.toString();
    }


}
