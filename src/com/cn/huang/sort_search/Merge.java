/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.sort_search;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * @author huangzuo
 * @version : Merge.java, v 0.1 2020年05月12日 3:34 下午 huangzuo Exp $
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //nums1、nums2都为有序整数数组，所以从nums1尾端入手开始插入nums2

        //定义指针，分别指向nums1有效元素的尾端和nums2有效元素的尾端
        int pointer1 = m-1;
        int pointer2 = n-1;
        //插入指针，为nums1数组最右端
        int len = nums1.length - 1;

        //循环条件为指针越界
        while ((pointer1 >=0) && (pointer2 >=0)){
            //比较两对应元素，谁大就放指针len处；哪边取元素，哪边移动指针
            nums1[len--] = nums1[pointer1] > nums2[pointer2] ? nums1[pointer1--] : nums2[pointer2--];
        }

        //处理特殊情况：nums1头元素大小在nums2元素中间，需要把比nums1头元素小的元素全部copy到nums1的左端
        System.arraycopy(nums2,0,nums1,0,pointer2+1);
    }


    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {0,5,6};
        Merge merge = new Merge();
        merge.merge(nums1,3,nums2,3);
        System.out.println(1);
    }
}
