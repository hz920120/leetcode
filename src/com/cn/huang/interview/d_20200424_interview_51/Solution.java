/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.interview.d_20200424_interview_51;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月24日 12:42 上午 huangzuo Exp $
 */
public class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length == 0 || nums.length == 1){return 0;}
        int res = 0 ;
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            res += pairCount(nums);
            nums = Arrays.copyOf(nums,nums.length-1);
        }

        return res;
    }

    private int pairCount(int[] nums){
        int res = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]){
                res++;
                int temp;
                temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] test = new int[]{7,5,6,4};
//        System.out.println(solution.reversePairs(test));
//        System.out.println(1);
        String str = "18758255514";
        System.out.println(str.contains("*"));
    }
}
