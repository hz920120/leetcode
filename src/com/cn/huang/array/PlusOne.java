/*
 * Miya.com Inc.
 * Copyright (c) 2004-2020 All Rights Reserved.
 */
package com.cn.huang.array;

/**
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * @author huangzuo
 * @version : PlusOne.java, v 0.1 2020年04月27日 12:26 上午 huangzuo Exp $
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits.length == 1 && digits[0] == 0){
            return new int[]{1};
        }
        int len = digits.length;
        //下面方法int会超出长度
//        int m = 0;
//        for (int i = 0; i < digits.length; i++) {
//            m += (digits[i] * Math.pow(10,len -1));
//            len--;
//        }
//        m = m+1;
//        char[] str = String.valueOf(m).toCharArray();
//        int[] res = new int[str.length];
//        for (int i = 0; i < str.length; i++) {
//            res[i] = str[i] - '0';
//        }
//
//        return res;


        //是否进位
        boolean carrier = false;

        for (int i = len -1; i >= 0; i--) {
            if (i == len -1){
                if (digits[i] + 1 < 10){
                    digits[i] = digits[i] + 1;
                    return digits;
                }else {
                    digits[i] = (digits[i] + 1)%10;
                    carrier = true;
                }
            }else {
                if (carrier){
                    if (digits[i] + 1 < 10){
                        digits[i] = digits[i] + 1;
                        return digits;
                    }else {
                        digits[i] = (digits[i] + 1)%10;
                    }
                }else {
                    return digits;
                }
            }
        }
        if (carrier){
            int[] res = new int[len+1];
            res[0]= 1;
            return res;
        }else {
            return digits;
        }

    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        plusOne.plusOne(new int[]{1,9,9});
    }
}
