/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * @author huangzuo
 * @version : Intersect.java, v 0.1 2020年04月24日 12:05 上午 huangzuo Exp $
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {return new int[]{};};
        //保证nums1的长度比nums2小
        if (nums1.length > nums2.length){
            return intersect(nums2,nums1);
        }
        Map<Integer, Integer> countMap1 = count(nums1);
        Map<Integer, Integer> countMap2 = count(nums2);
        Map<Integer, Integer> result = new HashMap<>();
        int len = 0;
        for (Map.Entry<Integer, Integer> ele: countMap1.entrySet()){
            if (countMap2.get(ele.getKey()) != null){
                int eleLen = Math.min(countMap2.get(ele.getKey()),ele.getValue());
                result.put(ele.getKey(),eleLen);
                len += eleLen;
            }
        }
        int[] res = new int[len];
        int index = 0;
        for (Map.Entry<Integer, Integer> ele: result.entrySet()){
            for (int i = 0; i < ele.getValue(); i++) {
                res[index] = ele.getKey();
                index++;
            }
        }

        return res;
    }

    private Map<Integer, Integer> count(int[] nums){
        Map<Integer, Integer> countMap1 = new HashMap<>();
        for (Integer int1 : nums){
            if (countMap1.get(int1) == null) {
                countMap1.put(int1,1);
            }else {
                countMap1.put(int1,countMap1.get(int1)+1);
            }
        }
        return countMap1;
    }


    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        int[] res = intersect.intersect(new int[]{4,9,5},new int[]{9,4,9,8,4});
        System.out.println(1);
    }
}
