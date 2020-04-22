/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月21日 9:26 下午 huangzuo Exp $
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){return 0;}
        Arrays.sort(nums);
        int len = nums.length;
        int ori = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] == ori){
                remove(nums,i);
                len--;
                i--;
            }else {
                ori = nums[i];
            }
        }
        return len;
    }

    private int[] remove(int[] nums,int index){
        for (int i = index; i < nums.length-1; i++) {
            nums[i] = nums[i + 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int[] arr = new int[]{1,2,3,3,4,3,5};
        System.out.println(removeDuplicates.removeDuplicates(arr));
        System.out.println("1");
    }
}
