package com.cn.leetcode2021;

import java.util.Arrays;

/**
 * @author HUANG Zuo
 * @version create_time：2021-10-06 09:07:39
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class ThirdMax_414 {

    public int thirdMax(int[] nums) {
        if (nums.length <= 2) {
            return nums.length == 1 ? nums[0] : Math.max(nums[0], nums[1]);
        }
        Arrays.sort(nums);

        int max = nums[nums.length - 1];
        int res = Integer.MIN_VALUE;
        int change = 0;


        for (int i = nums.length - 1; i >= 0; i--) {
            if (res != nums[i]) {
                res = nums[i];
                change++;
            }
            if (change == 3) break;
        }

        return change == 3 ? res : max;
    }

    public static void main(String[] args) {
        ThirdMax_414 thirdMax_414 = new ThirdMax_414();
        System.out.println(thirdMax_414.thirdMax(new int[]{1,2,3}));
    }

}
