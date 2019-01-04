package com.map;


import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author: fanbopeng
 * @Date: 2019/1/4 12:53
 * @Description:349. 两个数组的交集
 * <p>
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序
 */
public class LetCode350 {
    public static int[] intersect(int[] nums1, int[] nums2) {

        TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
        for (int i=0;i<nums1.length;i++){
            if (!map.containsKey(nums1[i])){
                map.put(nums1[i], 1);

            }else {
                map.put(nums1[i],map.get(nums1[i])+1 );
            }


        }
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int num:nums2){
            if (map.containsKey(num)){
                arrayList.add(num);
                map.put(num, map.get(num)-1);
                if (map.get(num)==0){

                    map.remove(num);
                }

            }


        }

        int[] ints=new int[arrayList.size()];

        for (int i=0;i<ints.length;i++){
            ints[i]=arrayList.get(i);

        }

        return ints;


    }


    public static void main(String[] args) {

        int[] a ={1,2,3,3,3};
        int[] b={1,2,2,3,3};

        intersect(a, b);

    }


}