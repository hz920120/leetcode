/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.march.d_20200324_question_70;

/**
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月24日 11:22 下午 huangzuo Exp $
 */
public class Solution {

    public int climbStairs(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }



        //到达第i阶台阶有两种方式，第一种方式是i-1时爬1，第二种方式是i-2时爬2，所以dp[i] = dp[i-1] + dp[i-2]

        int[] dp = new int[n];
        //初始化
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];


//        int[][] dp = new int[n][2];
        //设置一个状态 dp[i][0] : 表示迈第i个台阶用1步 , 取决于前一个台阶用1步或者是2步上来的 max(dp[i-1][0],dp[i-1][1]) + 1,台阶剩余数n-1
        //设置一个状态 dp[i][1] : 表示迈第i个台阶用2步 , 取决于前一个台阶用1步或者是2步上来的 dp[i-2][0]+1,台阶剩余数n-2
//        //初始化
//        dp[0][0] = 1;
//        dp[0][1] = 0;
//        dp[1][0] = 2;
//        dp[1][1] = 1;
//        int count1 =0;
//        int count2 =0;
//        for (int i = 2; i <= n; i++) {
//            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
//            dp[i][1] = dp[i-2][0]+1;
//        }

//        return count1+count2;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(5));

    }
}
