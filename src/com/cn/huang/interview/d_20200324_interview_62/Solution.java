/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.interview.d_20200324_interview_62;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月30日 10:31 上午 huangzuo Exp $
 */
public class Solution {

    public int lastRemaining(int n, int m) {

        //初始化输出位置为0
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = ( pos + m ) % i;
        }
        return pos;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lastRemaining(5,3);
    }

}
