package com.cn.leetcode2022;

/**
 * @author HUANG Zuo
 * @version create_time：2022-01-15 22:19:30
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class TotalMoney_1716 {

    public int totalMoney(int n) {
        int week = n / 7;
        int day = n % 7;

        n = 0;
        for (int i = 0; i < week; i++) {
            n += (((1 + i) + ((1 + i) + 6)) / 2) * 7;
        }
        for (int i = 0; i < day; i++) {
            n += ++week;
        }
        return n;
    }

    public static void main(String[] args) {
        TotalMoney_1716 totalMoney_1716 = new TotalMoney_1716();
        System.out.println(totalMoney_1716.totalMoney(20));
    }



}
