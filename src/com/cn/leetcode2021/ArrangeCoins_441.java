package com.cn.leetcode2021;

/**
 * @author HUANG Zuo
 * @version create_time：2021-10-10 13:46:38
 * @declaration
 * @e-mail hz920120@gmail.com
 */
public class ArrangeCoins_441 {

    public int arrangeCoins(int n) {
        if (n <= 2) {
            return 1;
        }

        int i = 1;
        while (n >= i) {
            n -= i++;
        }

        return i -1;
    }

}
