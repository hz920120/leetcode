package com.cn.leetcode2021;

/**
 * @author HUANG Zuo
 * @version create_time：2021-09-26 10:05:43
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class GetSum_371 {

    public int getSum(int a, int b) {
        while (b!=0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }


    public static void main(String[] args) {
        GetSum_371 getSum = new GetSum_371();
        System.out.println(getSum.getSum(2,3));
    }

}
