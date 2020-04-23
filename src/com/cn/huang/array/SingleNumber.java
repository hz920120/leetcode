/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author huangzuo
 * @version : SingleNumber.java, v 0.1 2020年04月23日 11:34 下午 huangzuo Exp $
 */
public class SingleNumber {
//    public int singleNumber(int[] nums) {
//        if (nums.length == 0){return 0;}
//        Arrays.sort(nums);
//
//        for (int i = 0; i < nums.length - 2; i++) {
//            if (nums[i] == nums[i + 1]) {
//                i++;
//            }else {
//                return nums[i];
//            }
//        }
//        return nums[nums.length - 1];
//    }

    public int singleNumber(int[] nums) {
        if (nums.length == 0){return 0;}
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer i : nums){
            if (map.get(i) == null){
                map.put(i,1);
            }else {
                map.put(i,2);
            }
        }
        for (Integer key : map.keySet()){
            if (map.get(key) == 1){
                return key;
            }
        }
        return -1;
    }
}
