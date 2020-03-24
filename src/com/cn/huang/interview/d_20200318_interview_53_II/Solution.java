/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.interview.d_20200318_interview_53_II;

import java.util.Arrays;

/**
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月18日 5:59 下午 huangzuo Exp $
 */
public class Solution {

    public static int missingNumber(int[] nums) {
        //中位数查找，如果中位数的值和索引数一直，查找后一半，否则查找前一半


        return method(nums);
    }

    private static int method(int[] a){
        if (a.length == 1){
            return a[0]+1;
        }
        if (a.length == 2){
            if (a[0]+1 == a[1]){
                return a[1] +1;
            }else {
                return a[0] + a.length/2;
            }
        }
        return (a[a.length/2] == a[0] + a.length/2) ? method(Arrays.copyOfRange(a,a.length/2 , a.length)) : method(Arrays.copyOfRange(a,0,a.length/2)) ;
    }
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};

        System.out.println(method(a));
//        int[] b = new int[]{1,2,3,4,5,6,7,9,10};
////        System.out.println(missingNumber(a));
//        System.out.println(a[a.length/2] == a[0] + a.length/2);
//        System.out.println(a[0] + a.length/2);
//
//        int[] result1 = new int[20];
//        int[] result2 = new int[20];;
//        result1 = Arrays.copyOfRange(a,0,a.length/2);
//        result2 = Arrays.copyOfRange(a,a.length/2 , a.length);
//
//        System.out.println(b[0]+b.length/2);
//        System.out.println(b.length/2);
    }
}
