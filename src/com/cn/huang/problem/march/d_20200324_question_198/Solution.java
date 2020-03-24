/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.march.d_20200324_question_198;

/**
 *
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them
 * is that adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月24日 10:42 下午 huangzuo Exp $
 */
public class Solution {

    public int rob(int[] nums) {

        int len = nums.length;
        if (len == 0){
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        //定义一个二维数组dp
        int[][] dp = new int[len][2];
        //偷取0-i个房间后的最大值，且第i个房间没有偷（0代表没偷）：dp[i][0] = max(dp[i-1][0],dp[i-1][1])
        //偷取0-i个房间后的最大值，且第i个房间已偷（1代表偷了）：dp[i][1] = dp[i-1][0]+nums[i]

        //初始化dp：偷第一个房间（1）或者不偷第一个房间（0）
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        //开偷
        for (int i = 1; i < len; i++) {
            //第i个房间没偷的最大值取决有第i-1个房间偷了或者没偷的最大值
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            //第i个房间偷了的最大值取决于前一个房间没偷并加上这个房间的值
            dp[i][1] = dp[i-1][0]+nums[i];
        }

        //取最有一个房间不偷或者偷的最大值
        return Math.max(dp[len-1][0],dp[len-1][1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1,2,3,1}));
    }
}
