/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200414_question_67;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 *
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 *
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *  
 *
 * Constraints:
 *
 * Each string consists only of '0' or '1' characters.
 * 1 <= a.length, b.length <= 10^4
 * Each string is either "0" or doesn't contain any leading zero.
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月14日 11:02 下午 huangzuo Exp $
 */
public class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0){
            return "";
        }

        if (b == null || b.length() == 0){
            return "";
        }

        char[] cha = a.toCharArray();
        char[] chb = b.toCharArray();

        Deque<Character> dqa = new ArrayDeque<>();
        Deque<Character> dqb = new ArrayDeque<>();

        for (char ch : cha){
            dqa.push(ch);
        }

        for (char ch : chb){
            dqb.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        while (!dqa.isEmpty() || !dqb.isEmpty() || carry){
            int sumA = dqa.size() > 0 ? dqa.pop()-'0' : 0;
            int sumB = dqb.size() > 0 ? dqb.pop()-'0' : 0;
            if (carry){
                sb.append((sumA + sumB + 1)%2);
                carry = sumA + sumB + 1 >= 2;
            }else {
                if (sumA + sumB == 2){
                    sb.append("0");
                    carry = true;
                }else {
                    sb.append(sumA + sumB);
                }
            }
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("0","0"));
    }
}
