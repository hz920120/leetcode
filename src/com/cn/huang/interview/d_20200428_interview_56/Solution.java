/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.interview.d_20200428_interview_56;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *  
 *
 * 限制：
 *
 * 2 <= nums <= 10000
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月28日 10:49 下午 huangzuo Exp $
 */
public class Solution {
    public int[] singleNumbers(int[] nums) {
        if (nums.length==2){return nums;}
        int[] res = new int[2];
        //假设不重复的两个数
        int single1 = nums[0];
        int single2 = nums[1];
        for (int i = 0; i < nums.length; i++) {

        }
        return nums;
    }
}
