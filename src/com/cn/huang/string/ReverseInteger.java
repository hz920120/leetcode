/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.string;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @author huangzuo
 * @version : ReverseInteger.java, v 0.1 2020年05月06日 10:31 下午 huangzuo Exp $
 */
public class ReverseInteger {
    public int reverse(int x) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        char temp;
        char[] charX = String.valueOf(x).toCharArray();
        StringBuffer sb = new StringBuffer();
        if (x == 0) {
            return x;
        }else if (x > 0){
            for (int i = 0; i < charX.length / 2; i++) {
                temp = charX[i];
                charX[i] = charX[charX.length - 1 - i];
                charX[charX.length - 1 - i] = temp;
            }
            for (int i = 0; i < charX.length; i++) {
                sb.append(charX[i]);
            }
            return Long.parseLong(sb.toString()) > max ? 0 : Integer.parseInt(sb.toString());
        }else {
            for (int i = 0; i < charX.length / 2; i++) {
                temp = charX[i];
                charX[i] = charX[charX.length - 1 - i];
                charX[charX.length - 1 - i] = temp;
            }
            for (int i = 0; i < charX.length - 1; i++) {
                sb.append(charX[i]);
            }
            return -Long.parseLong(sb.toString()) < min ? 0 : -Integer.parseInt(sb.toString());
        }
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println(reverseInteger.reverse(-120));
    }
}
