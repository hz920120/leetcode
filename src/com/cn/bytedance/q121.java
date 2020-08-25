/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.bytedance;

/**
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author huangzuo
 * @version : q121.java, v 0.1 2020年08月23日 11:11 下午 huangzuo Exp $
 */
public class q121 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int cost = Integer.MAX_VALUE;

        for (int price : prices) {
            //花费价格是当前价格与历史价格的最小值
            cost = Math.min(price,cost);
            //利润是老利润与新利润的最大值
            profit = Math.max(profit,price-cost);
        }
        return profit;
    }
}
