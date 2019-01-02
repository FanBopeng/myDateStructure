package com.recursion;

/**
 * @author: fanbopeng
 * @Date: 2019/1/2 11:42
 * @Description: 计算数组数字和
 */
public class Sum{


    public  static int sum(int[] arr){

        return sum(arr, 0);


    }

    private  static  int sum(int[] arr,int index){
      if (index==arr.length){

          return 0;
      }
        return arr[index]+sum(arr,index+1);


    }

    public static void main(String[] args) {

        int[] a={1,2,34,2};

        System.out.println(sum(a));

    }


}
