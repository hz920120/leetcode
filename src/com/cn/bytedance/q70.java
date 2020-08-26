/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * @author huangzuo
 * @version : q70.java, v 0.1 2020年08月25日 9:39 下午 huangzuo Exp $
 */
public class q70 {


    /**
     * 爬上第n阶楼梯有两种方法：1：爬到第n-1阶楼梯，再爬一步；2：爬到第n-2阶楼梯，再爬两步
     * 所以：
     * dp[n] = dp[n-1] + dp[n-2]
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
