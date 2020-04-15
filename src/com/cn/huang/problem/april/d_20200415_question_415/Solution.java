/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.problem.april.d_20200415_question_415;

import java.util.Deque;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * @author huangzuo
 * @version : Solution.java, v 0.1 2020年04月15日 12:18 上午 huangzuo Exp $
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.equals("0")){return num2;}
        if (num2.equals("0")){return num1;}

        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();

        StringBuilder sb = new StringBuilder();
        int carrier = 0;

        for (int i = ch1.length - 1,j = ch2.length - 1; i >=0 || j >= 0 || carrier==1; i--,j--) {
            int n1 = (i < 0) ? 0 : ch1[i]-'0';
            int n2 = (j < 0) ? 0 : ch2[j]-'0';
            if (n1 + n2 + carrier >= 10){
                sb.append((n1 + n2 + carrier) % 10);
                carrier = 1;
            }else {
                sb.append(n1 + n2 + carrier);
                carrier = 0;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addStrings("1","9"));
    }
}
