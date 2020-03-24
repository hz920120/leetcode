/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.interview.d_20200324_interview_17_16;

/**
 *
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，
 * 因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月24日 4:17 下午 huangzuo Exp $
 */
public class Solution {

    public int massage(int[] nums) {
        //  输入： [2,1,4,5,3,1,1,3]
        //  输出： 12
        //  解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12。

        int len = nums.length;
        if (len == 0){
            return 0;
        }
        if (len == 1){
            return nums[0];
        }

        //dp[i][0]:第0-i天的最优值，且第i天不接受预约；
        //dp[i][1]:第0-i天的最优值，且第i天接受预约；
        int[][] dp = new int[len][2];

        //初始化dp，及第一天的最优值
        dp[0][0]=0;
        dp[0][1]=nums[0];

        for (int i = 1; i < len; i++) {
            //第i天不接受预约取决于前一天接受或不接受预约的最优值
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            //第i天不接受预约取决于前一天不接受预约的最优值，即跟dp[i-1][0]相关
            dp[i][1] = dp[i-1][0] + nums[i];
        }

        //取最后一天预约或者不预约的最大值即为最优解
        return Math.max(dp[len-1][0],dp[len-1][1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] nums = {1, 2, 3, 1};
        // int[] nums = {2, 7, 9, 3, 1};
        //* 输入： [2,1,4,5,3,1,1,3]
        // * 输出： 12
        int[] nums = {2, 1, 4, 5, 3, 1, 1, 3};
        int res = solution.massage(nums);
        System.out.println(res);
    }

}
