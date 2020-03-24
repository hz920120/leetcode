/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.interview.problem.march.d_20200319_question_461;

/**
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 2^31.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 *
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年03月19日 4:12 下午 huangzuo Exp $
 */
public class Solution {

    public static int hammingDistance(int x, int y) {
        if (x < y){
            return hammingDistance(y,x);
        }
        //找到循环次数

        int count = 0;
        for (int i = countRound(x,0) ; i > 0; i--){
            if (x % 2 != y % 2){
                count ++;
            }
            x = (x >> 1);
            y = (y >> 1);
        }
        return count;
    }

    private static int countRound(int num,int round){
        if (num == 0){
            return round ++ ;
        }

        return countRound(num >> 1,round +1);
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
//
        System.out.println(3 - (3 >> 1) );
    }
}
