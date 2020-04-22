/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.array;

import java.util.Arrays;

/**
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: true
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 *
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 * @author huangzuo
 * @version : ContainsDuplicate.java, v 0.1 2020年04月22日 11:54 下午 huangzuo Exp $
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0 || nums.length == 1){return false;}
        Arrays.sort(nums);
        //左边单调递增
        int leftPointer = 0;
        //右边单调递减
        int rightPointer = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[leftPointer+1]-nums[leftPointer] <= 0){
                return true;
            }else {
                leftPointer++;
            }
            if (nums[rightPointer]-nums[rightPointer-1] <= 0){
                return true;
            }else {
                rightPointer--;
            }
            if (leftPointer >= rightPointer){break;}
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        System.out.println(containsDuplicate.containsDuplicate(new int[]{1,2,3,4,5,6}));
    }
}
