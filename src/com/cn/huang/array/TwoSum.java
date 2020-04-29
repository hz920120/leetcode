/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author huangzuo
 * @version : TwoSum.java, v 0.1 2020年04月29日 11:39 下午 huangzuo Exp $
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //特判
        if (nums.length == 2){return new int[]{0,1};}
        //key存值，value存下标
        Map<Integer,Integer> keyValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (keyValue.containsKey(target-nums[i])){
                return new int[]{keyValue.get(target-nums[i]),i};
            }else {
                keyValue.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] res = twoSum.twoSum(new int[]{3,3},6);
        System.out.println(1);
    }
}
